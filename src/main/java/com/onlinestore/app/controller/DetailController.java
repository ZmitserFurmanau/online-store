package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.request.DetailRequestDto;
import com.onlinestore.app.dto.response.DetailResponseDto;
import com.onlinestore.app.model.Car;
import com.onlinestore.app.model.Detail;
import com.onlinestore.app.model.Stock;
import com.onlinestore.app.service.DetailService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Detail controller.
 */
@RestController
@RequestMapping("/details")
public class DetailController {

    private final Mapper mapper;

    private final DetailService detailService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Detail controller.
     *
     * @param mapper                 the mapper
     * @param detailService          the detail service
     * @param localizedMessageSource the localized message source
     */
    public DetailController(final Mapper mapper,
                            final DetailService detailService,
                            final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.detailService = detailService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<DetailResponseDto>> getAll() {
        final List<Detail> details = detailService.findAll();
        final List<DetailResponseDto> detailResponseDtoList = details.stream()
                .map((detail) -> mapper.map(detail, DetailResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(detailResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<DetailResponseDto> getOne(@PathVariable Long id) {
        final DetailResponseDto detailResponseDto;
        detailResponseDto = mapper.map(detailService.findById(id), DetailResponseDto.class);
        return new ResponseEntity<>(detailResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param detailRequestDto the detail request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<DetailResponseDto> save(@RequestBody DetailRequestDto detailRequestDto) {
        detailRequestDto.setId(null);
        final DetailResponseDto detailResponseDto = mapper.map(detailService
                .save(getDetail(detailRequestDto)), DetailResponseDto.class);
        return new ResponseEntity<>(detailResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param detailRequestDto the detail request dto
     * @param id               the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<DetailResponseDto> update(@RequestBody DetailRequestDto detailRequestDto,
                                                    @PathVariable Long id) throws RuntimeException {
        if (!Objects.equals(id, detailRequestDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.detail.unexpectedId", new Object[]{}));
        final DetailResponseDto detailResponseDto = mapper.map(detailService
                .update(getDetail(detailRequestDto)), DetailResponseDto.class);
        return new ResponseEntity<>(detailResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        detailService.deleteById(id);
    }

    private Detail getDetail(DetailRequestDto detailRequestDto) {
        final Detail detail = mapper.map(detailRequestDto, Detail.class);
        final Car car = new Car();
        car.setId(detailRequestDto.getCarId());
        detail.setCar(car);
        final Set<Stock> stockSet = detailRequestDto.getStockId().stream().map(stockId -> {
            Stock stock = new Stock();
            stock.setId(stockId);
            return stock;
        }).collect(Collectors.toSet());
        detail.setStocks(stockSet);
        return detail;
    }
}
