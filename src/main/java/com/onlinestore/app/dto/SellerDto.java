package com.onlinestore.app.dto;

/**
 * The type Seller dto.
 */
public class SellerDto {

    private Long id;

    private String name;

    private Short age;

    private Integer salary;

    private Short category;

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public Short getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Short getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Short category) {
        this.category = category;
    }
}