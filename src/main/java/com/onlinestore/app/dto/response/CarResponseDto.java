package com.onlinestore.app.dto.response;

/**
 * The type Car response dto.
 */
public class CarResponseDto {

    private Long id;

    private String model;

    private Short year;

    private String pinCode;

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
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public Short getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * Gets pin code.
     *
     * @return the pin code
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * Sets pin code.
     *
     * @param pinCode the pin code
     */
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
