package com.onlinestore.app.dto.request;

/**
 * The type Heaver request dto.
 */
public class HeaverRequestDto {

    private Long id;

    private String name;

    private Short age;

    private Integer salary;

    private Integer bonus;

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
