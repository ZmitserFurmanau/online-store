package com.onlinestore.app.dto.response;

import com.onlinestore.app.dto.*;

/**
 * The type Order response dto.
 */
public class OrderResponseDto {

    private Long id;

    private String date;

    private Integer sum;

    private SellerDto seller;

    private DetailDto detail;

    private StockDto stock;

    private CustomerDto customer;

    private AddressDto address;

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
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets sum.
     *
     * @return the sum
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * Sets sum.
     *
     * @param sum the sum
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }

    /**
     * Gets seller.
     *
     * @return the seller
     */
    public SellerDto getSeller() {
        return seller;
    }

    /**
     * Sets seller.
     *
     * @param seller the seller
     */
    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }

    /**
     * Gets details stocks.
     *
     * @return the details stocks
     */
    public DetailDto getDetail() {
        return detail;
    }

    /**
     * Sets detail.
     *
     * @param detail the detail
     */
    public void setDetail(DetailDto detail) {
        this.detail = detail;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public StockDto getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(StockDto stock) {
        this.stock = stock;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public CustomerDto getCustomer() {
        return customer;
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public AddressDto getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
