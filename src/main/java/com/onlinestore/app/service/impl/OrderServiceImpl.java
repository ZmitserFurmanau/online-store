package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Order;
import com.onlinestore.app.repository.OrderRepository;
import com.onlinestore.app.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Order service.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final SellerService sellerService;

    private final DetailService detailService;

    private final StockService stockService;

    private final CustomerService customerService;

    private final AddressService addressService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Order service.
     *
     * @param orderRepository        the order repository
     * @param sellerService          the seller service
     * @param detailService          the detail service
     * @param stockService           the stock service
     * @param customerService        the customer service
     * @param addressService         the address service
     * @param localizedMessageSource the localized message source
     */
    public OrderServiceImpl(final OrderRepository orderRepository,
                            final SellerService sellerService,
                            final DetailService detailService,
                            final StockService stockService,
                            final CustomerService customerService,
                            final AddressService addressService,
                            final LocalizedMessageSource localizedMessageSource) {
        this.orderRepository = orderRepository;
        this.sellerService = sellerService;
        this.detailService = detailService;
        this.stockService = stockService;
        this.customerService = customerService;
        this.addressService = addressService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.order.notExist", new Object[]{})));
    }

    @Override
    public Order save(Order order) {
        validate(order.getId() != null, localizedMessageSource
                .getMessage("error.order.notHaveId", new Object[]{}));
        validate(orderRepository.existsByDate(order.getDate()), localizedMessageSource
                .getMessage("error.order.date.notUnique", new Object[]{}));
        return saveAndFlush(order);
    }

    @Override
    public Order update(Order order) {
        final Long id = order.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.order.haveId", new Object[]{}));
        final Order duplicateOrder = orderRepository.findByDate(order.getDate());
        final boolean isDuplicateExists = duplicateOrder != null && !Objects.equals(duplicateOrder.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.order.date.notUnique", new Object[]{}));
        findById(id);
        return saveAndFlush(order);
    }


    @Override
    public void delete(Order order) {
        final Long id = order.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.order.haveId", new Object[]{}));
        findById(id);
        orderRepository.delete(order);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        orderRepository.deleteById(id);
    }

    private Order saveAndFlush(Order order) {
        validate(order.getSeller() == null || order.getSeller().getId() == null, localizedMessageSource
                .getMessage("error.order.seller.isNull", new Object[]{}));
        order.setSeller(sellerService.findById(order.getSeller().getId()));
        validate(order.getDetail() == null || order.getDetail().getId() == null, localizedMessageSource
                .getMessage("error.order.detail.isNull", new Object[]{}));
        order.setDetail(detailService.findById(order.getDetail().getId()));
        validate(order.getStock() == null || order.getStock().getId() == null, localizedMessageSource
                .getMessage("error.order.stock.isNull", new Object[]{}));
        order.setStock(stockService.findById(order.getStock().getId()));
        validate(order.getCustomer() == null || order.getCustomer().getId() == null, localizedMessageSource
                .getMessage("error.order.customer.isNull", new Object[]{}));
        order.setCustomer(customerService.findById(order.getCustomer().getId()));
        validate(order.getAddress() == null || order.getAddress().getId() == null, localizedMessageSource
                .getMessage("error.order.address.isNull", new Object[]{}));
        order.setAddress(addressService.findById(order.getAddress().getId()));
        return orderRepository.saveAndFlush(order);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
