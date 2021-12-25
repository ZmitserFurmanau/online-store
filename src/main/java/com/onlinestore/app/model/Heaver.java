package com.onlinestore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Heaver.
 */
@Entity
@Table(name = "heavers", schema = "public")
public class Heaver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.name.notNull}")
    @NotEmpty(message = "{heaver.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.age.notNull}")
    @NotEmpty(message = "{heaver.age.notEmpty}")
    private Short age;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.salary.notNull}")
    @NotEmpty(message = "{heaver.salary.notEmpty}")
    private Integer salary;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.bonus.notNull}")
    @NotEmpty(message = "{heaver.bonus.notEmpty}")
    private Integer bonus;

    /**
     * Instantiates a new Heaver.
     */
    public Heaver() {
    }

    /**
     * Instantiates a new Heaver.
     *
     * @param name   the name
     * @param age    the age
     * @param salary the salary
     * @param bonus  the bonus
     */
    public Heaver(final String name, final Short age, final Integer salary, final Integer bonus) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
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
     * Gets bonus.
     *
     * @return the bonus
     */
    public Integer getBonus() {
        return bonus;
    }

    /**
     * Sets bonus.
     *
     * @param bonus the bonus
     */
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
