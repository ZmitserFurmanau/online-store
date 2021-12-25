package com.onlinestore.app.service;

import com.onlinestore.app.model.Car;

import java.util.List;

/**
 * The interface Car service.
 */
public interface CarService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Car> findAll();

    /**
     * Find by id car.
     *
     * @param id the id
     * @return the car
     */
    Car findById(Long id);

    /**
     * Save car.
     *
     * @param car the car
     * @return the car
     */
    Car save(Car car);

    /**
     * Update car.
     *
     * @param car the car
     * @return the car
     */
    Car update(Car car);

    /**
     * Delete.
     *
     * @param car the car
     */
    void delete(Car car);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
