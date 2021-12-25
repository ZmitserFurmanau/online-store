package com.onlinestore.app.repository;

import com.onlinestore.app.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Car repository.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    /**
     * Exists by model boolean.
     *
     * @param model the model
     * @return the boolean
     */
    boolean existsByModel(String model);

    /**
     * Find by model car.
     *
     * @param model the model
     * @return the car
     */
    Car findByModel(String model);
}
