package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Address.
 */
@Entity
@Table(name = "addresses", schema = "public")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.phoneNumber.notNull}")
    @NotEmpty(message = "{address.phoneNumber.notEmpty}")
    private Integer phoneNumber;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.street.notNull}")
    @NotEmpty(message = "{address.street.notEmpty}")
    private String street;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.city.notNull}")
    @NotEmpty(message = "{address.city.notEmpty}")
    private String city;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.state.notNull}")
    @NotEmpty(message = "{address.state.notEmpty}")
    private String state;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.country.notNull}")
    @NotEmpty(message = "{address.country.notEmpty}")
    private String country;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{address.pinCode.notNull}")
    @NotEmpty(message = "{address.pinCode.notEmpty}")
    private Integer pinCode;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "addresses")
    private Set<Customer> customers = new HashSet<>();

    /**
     * Instantiates a new Address.
     */
    public Address() {
    }

    /**
     * Instantiates a new Address.
     *
     * @param phoneNumber the phone number
     * @param street      the street
     * @param city        the city
     * @param state       the state
     * @param country     the country
     * @param pinCode     the pin code
     */
    public Address(final Integer phoneNumber,
                   final String street,
                   final String city,
                   final String state,
                   final String country,
                   final Integer pinCode) {
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets pin code.
     *
     * @return the pin code
     */
    public Integer getPinCode() {
        return pinCode;
    }

    /**
     * Sets pin code.
     *
     * @param pinCode the pin code
     */
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * Gets customers.
     *
     * @return the customers
     */
    public Set<Customer> getCustomers() {
        return customers;
    }

    /**
     * Sets customers.
     *
     * @param customers the customers
     */
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
