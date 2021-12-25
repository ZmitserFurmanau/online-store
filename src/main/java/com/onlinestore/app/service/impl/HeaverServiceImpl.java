package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Heaver;
import com.onlinestore.app.repository.HeaverRepository;
import com.onlinestore.app.service.HeaverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Heaver service.
 */
@Service
@Transactional
public class HeaverServiceImpl implements HeaverService {

    private final HeaverRepository heaverRepository;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Heaver service.
     *
     * @param heaverRepository       the heaver repository
     * @param localizedMessageSource the localized message source
     */
    public HeaverServiceImpl(final HeaverRepository heaverRepository,
                             final LocalizedMessageSource localizedMessageSource) {
        this.heaverRepository = heaverRepository;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Heaver> findAll() {
        return heaverRepository.findAll();
    }

    @Override
    public Heaver findById(Long id) {
        return heaverRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.heaver.notExist", new Object[]{})));
    }

    @Override
    public Heaver save(Heaver heaver) {
        validate(heaver.getId() != null, localizedMessageSource
                .getMessage("error.heaver.notHaveId", new Object[]{}));
        validate(heaverRepository.existsByName(heaver.getName()), localizedMessageSource
                .getMessage("error.heaver.name.notUnique", new Object[]{}));
        return heaverRepository.saveAndFlush(heaver);
    }

    @Override
    public Heaver update(Heaver heaver) {
        final Long id = heaver.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.heaver.haveId", new Object[]{}));
        final Heaver duplicateHeaver = heaverRepository.findByName(heaver.getName());
        findById(id);
        final boolean isDuplicateExists = duplicateHeaver != null
                && !Objects.equals(duplicateHeaver.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.heaver.name.notUnique", new Object[]{}));
        return heaverRepository.saveAndFlush(heaver);
    }

    @Override
    public void delete(Heaver heaver) {
        final Long id = heaver.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.heaver.haveId", new Object[]{}));
        findById(id);
        heaverRepository.delete(heaver);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        heaverRepository.deleteById(id);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
