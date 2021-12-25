package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Detail;
import com.onlinestore.app.repository.DetailRepository;
import com.onlinestore.app.service.CarService;
import com.onlinestore.app.service.DetailService;
import com.onlinestore.app.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Detail service.
 */
@Service
@Transactional
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;

    private final CarService carService;

    private final StockService stockService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Detail service.
     *
     * @param detailRepository       the detail repository
     * @param carService             the car service
     * @param stockService           the stock service
     * @param localizedMessageSource the localized message source
     */
    public DetailServiceImpl(final DetailRepository detailRepository,
                             final CarService carService,
                             final StockService stockService,
                             final LocalizedMessageSource localizedMessageSource) {
        this.detailRepository = detailRepository;
        this.carService = carService;
        this.stockService = stockService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail findById(Long id) {
        return detailRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.detail.notExist", new Object[]{})));
    }

    @Override
    public Detail save(Detail detail) {
        validate(detail.getId() != null, localizedMessageSource
                .getMessage("error.detail.notHaveId", new Object[]{}));
        validate(detailRepository.existsByName(detail.getName()), localizedMessageSource
                .getMessage("error.detail.name.notUnique", new Object[]{}));
        return saveAndFlush(detail);
    }

    @Override
    public Detail update(Detail detail) {
        final Long id = detail.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.detail.haveId", new Object[]{}));
        final Detail duplicateDetail = detailRepository.findByName(detail.getName());
        findById(id);
        final boolean isDuplicateExists = duplicateDetail != null
                && !Objects.equals(duplicateDetail.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.detail.name.notUnique", new Object[]{}));
        return saveAndFlush(detail);
    }

    @Override
    public void delete(Detail detail) {
        final Long id = detail.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.detail.haveId", new Object[]{}));
        findById(id);
        detailRepository.delete(detail);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        detailRepository.deleteById(id);
    }

    private Detail saveAndFlush(Detail detail) {
        validate(detail.getCar() == null || detail.getCar().getId() == null, localizedMessageSource
                .getMessage("error.detail.car.isNull", new Object[]{}));
        detail.setCar(carService.findById(detail.getCar().getId()));
        detail.getStocks().forEach(stock -> {
            validate(stock == null || stock.getId() == null, localizedMessageSource
                    .getMessage("error.detail.stocks.isNull", new Object[]{}));
            stock.setQuantity(stockService.findById(stock.getId()).getQuantity());
        });
        return detailRepository.saveAndFlush(detail);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
