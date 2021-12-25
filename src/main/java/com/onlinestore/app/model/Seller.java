package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Seller.
 */
@Entity
@Table(name = "sellers", schema = "public")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.name.notNull}")
    @NotEmpty(message = "{seller.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.age.notNull}")
    @NotEmpty(message = "{seller.age.notEmpty}")
    private Short age;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.salary.notNull}")
    @NotEmpty(message = "{seller.salary.notEmpty}")
    private Integer salary;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.category.notNull}")
    @NotEmpty(message = "{seller.category.notEmpty}")
    private Short category;

    /**
     * Instantiates a new Seller.
     */
    public Seller() {
    }

    /**
     * Instantiates a new Seller.
     *
     * @param name     the name
     * @param age      the age
     * @param salary   the salary
     * @param category the category
     */
    public Seller(final String name, final Short age, final Integer salary, final Short category) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.category = category;
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
