package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Provider;
import com.onlinestore.app.repository.ProviderRepository;
import com.onlinestore.app.service.ProviderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Provider service.
 */
@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Provider service.
     *
     * @param providerRepository     the provider repository
     * @param localizedMessageSource the localized message source
     */
    public ProviderServiceImpl(final ProviderRepository providerRepository,
                               final LocalizedMessageSource localizedMessageSource) {
        this.providerRepository = providerRepository;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider findById(Long id) {
        return providerRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.provider.notExist", new Object[]{})));
    }

    @Override
    public Provider save(Provider provider) {
        validate(provider.getId() != null, localizedMessageSource
                .getMessage("error.provider.notHaveId", new Object[]{}));
        validate(providerRepository.existsByName(provider.getName()), localizedMessageSource
                .getMessage("error.provider.name.notUnique", new Object[]{}));
        return providerRepository.saveAndFlush(provider);
    }

    @Override
    public Provider update(Provider provider) {
        final Long id = provider.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.provider.haveId", new Object[]{}));
        final Provider duplicateCustomer = providerRepository.findByName(provider.getName());
        final boolean isDuplicateExists = duplicateCustomer != null
                && !Objects.equals(duplicateCustomer.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.provider.name.notUnique", new Object[]{}));
        findById(id);
        return providerRepository.saveAndFlush(provider);
    }


    @Override
    public void delete(Provider provider) {
        final Long id = provider.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.provider.haveId", new Object[]{}));
        findById(id);
        providerRepository.delete(provider);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        providerRepository.deleteById(id);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
