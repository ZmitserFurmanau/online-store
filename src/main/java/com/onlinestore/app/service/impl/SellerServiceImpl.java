package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Seller;
import com.onlinestore.app.repository.SellerRepository;
import com.onlinestore.app.service.SellerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Seller service.
 */
@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Seller service.
     *
     * @param sellerRepository       the seller repository
     * @param localizedMessageSource the localized message source
     */
    public SellerServiceImpl(final SellerRepository sellerRepository,
                             final LocalizedMessageSource localizedMessageSource) {
        this.sellerRepository = sellerRepository;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.seller.notExist", new Object[]{})));
    }

    @Override
    public Seller save(Seller seller) {
        validate(seller.getId() != null, localizedMessageSource
                .getMessage("error.seller.notHaveId", new Object[]{}));
        validate(sellerRepository.existsByName(seller.getName()), localizedMessageSource
                .getMessage("error.seller.name.notUnique", new Object[]{}));
        return sellerRepository.saveAndFlush(seller);
    }

    @Override
    public Seller update(Seller seller) {
        final Long id = seller.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.seller.haveId", new Object[]{}));
        final Seller duplicateSeller = sellerRepository.findByName(seller.getName());
        findById(id);
        final boolean isDuplicateExists = duplicateSeller != null
                && !Objects.equals(duplicateSeller.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.seller.name.notUnique", new Object[]{}));
        return sellerRepository.saveAndFlush(seller);
    }

    @Override
    public void delete(Seller seller) {
        final Long id = seller.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.seller.haveId", new Object[]{}));
        findById(id);
        sellerRepository.delete(seller);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        sellerRepository.deleteById(id);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
