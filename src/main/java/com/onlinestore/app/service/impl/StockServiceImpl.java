package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Stock;
import com.onlinestore.app.repository.StockRepository;
import com.onlinestore.app.service.HeaverService;
import com.onlinestore.app.service.ProviderService;
import com.onlinestore.app.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Stock service.
 */
@Service
@Transactional
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    private final ProviderService providerService;

    private final HeaverService heaverService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Stock service.
     *
     * @param stockRepository        the stock repository
     * @param providerService        the provider service
     * @param heaverService          the heaver service
     * @param localizedMessageSource the localized message source
     */
    public StockServiceImpl(final StockRepository stockRepository,
                            final ProviderService providerService,
                            final HeaverService heaverService,
                            final LocalizedMessageSource localizedMessageSource) {
        this.stockRepository = stockRepository;
        this.providerService = providerService;
        this.heaverService = heaverService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.stock.notExist", new Object[]{})));
    }

    @Override
    public Stock save(Stock stock) {
        validate(stock.getId() != null, localizedMessageSource
                .getMessage("error.stock.notHaveId", new Object[]{}));
        validate(stockRepository.existsByQuantity(stock.getQuantity()), localizedMessageSource
                .getMessage("error.stock.quantity.notUnique", new Object[]{}));
        return saveAndFlush(stock);
    }

    @Override
    public Stock update(Stock stock) {
        final Long id = stock.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.stock.haveId", new Object[]{}));
        final Stock duplicateStock = stockRepository.findByQuantity(stock.getQuantity());
        final boolean isDuplicateExists = duplicateStock != null && !Objects.equals(duplicateStock.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.stock.quantity.notUnique", new Object[]{}));
        findById(id);
        return saveAndFlush(stock);
    }


    @Override
    public void delete(Stock stock) {
        final Long id = stock.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.stock.haveId", new Object[]{}));
        findById(id);
        stockRepository.delete(stock);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        stockRepository.deleteById(id);
    }

    private Stock saveAndFlush(Stock stock) {
        validate(stock.getProvider() == null || stock.getProvider().getId() == null, localizedMessageSource
                .getMessage("error.stock.provider.isNull", new Object[]{}));
        stock.setProvider(providerService.findById(stock.getProvider().getId()));
        validate(stock.getHeaver() == null || stock.getHeaver().getId() == null, localizedMessageSource
                .getMessage("error.stock.heaver.isNull", new Object[]{}));
        stock.setHeaver(heaverService.findById(stock.getHeaver().getId()));
        return stockRepository.saveAndFlush(stock);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
