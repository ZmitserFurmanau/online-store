package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.Customer;
import com.onlinestore.app.repository.CustomerRepository;
import com.onlinestore.app.service.AddressService;
import com.onlinestore.app.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type Customer service.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final AddressService addressService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Customer service.
     *
     * @param customerRepository     the customer repository
     * @param addressService         the address service
     * @param localizedMessageSource the localized message source
     */
    public CustomerServiceImpl(final CustomerRepository customerRepository,
                               final AddressService addressService,
                               final LocalizedMessageSource localizedMessageSource) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.customer.notExist", new Object[]{})));
    }

    @Override
    public Customer save(Customer customer) {
        validate(customer.getId() != null, localizedMessageSource
                .getMessage("error.customer.notHaveId", new Object[]{}));
        validate(customerRepository.existsByName(customer.getName()), localizedMessageSource
                .getMessage("error.customer.name.notUnique", new Object[]{}));
        return saveAndFlush(customer);
    }

    @Override
    public Customer update(Customer customer) {
        final Long id = customer.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.customer.haveId", new Object[]{}));
        final Customer duplicateCustomer = customerRepository.findByName(customer.getName());
        final boolean isDuplicateExists = duplicateCustomer != null
                && !Objects.equals(duplicateCustomer.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.customer.name.notUnique", new Object[]{}));
        findById(id);
        return saveAndFlush(customer);
    }


    @Override
    public void delete(Customer customer) {
        final Long id = customer.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.customer.haveId", new Object[]{}));
        findById(id);
        customerRepository.delete(customer);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }

    private Customer saveAndFlush(Customer customer) {
        customer.getAddresses().forEach(address -> {
            validate(address == null || address.getId() == null, localizedMessageSource
                    .getMessage("error.customer.addresses.isNull", new Object[]{}));
            address.setPhoneNumber(addressService.findById(address.getId()).getPhoneNumber());
        });
        return customerRepository.saveAndFlush(customer);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
