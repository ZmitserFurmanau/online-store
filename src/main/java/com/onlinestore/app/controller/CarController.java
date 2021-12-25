package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.request.CarRequestDto;
import com.onlinestore.app.dto.response.CarResponseDto;
import com.onlinestore.app.model.Car;
import com.onlinestore.app.service.CarService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Car controller.
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    private final Mapper mapper;

    private final CarService carService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Car controller.
     *
     * @param mapper                 the mapper
     * @param carService             the car service
     * @param localizedMessageSource the localized message source
     */
    public CarController(final Mapper mapper,
                         final CarService carService,
                         final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.carService = carService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAll() {
        final List<Car> cars = carService.findAll();
        final List<CarResponseDto> carResponseDtoList = cars.stream()
                .map((car) -> mapper.map(car, CarResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(carResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CarResponseDto> getOne(@PathVariable Long id) {
        final CarResponseDto carResponseDto = mapper.map(carService.findById(id), CarResponseDto.class);
        return new ResponseEntity<>(carResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param carRequestDto the car request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<CarResponseDto> save(@RequestBody CarRequestDto carRequestDto) {
        carRequestDto.setId(null);
        final CarResponseDto carResponseDto = mapper.map(carService
                .save(mapper.map(carRequestDto, Car.class)), CarResponseDto.class);
        return new ResponseEntity<>(carResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param carRequestDto the car request dto
     * @param id            the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<CarResponseDto> update(@RequestBody CarRequestDto carRequestDto,
                                                 @PathVariable Long id) throws RuntimeException {
        if (!Objects.equals(id, carRequestDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.car.unexpectedId", new Object[]{}));
        final CarResponseDto carResponseDto = mapper.map(carService
                .update(mapper.map(carRequestDto, Car.class)), CarResponseDto.class);
        return new ResponseEntity<>(carResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
