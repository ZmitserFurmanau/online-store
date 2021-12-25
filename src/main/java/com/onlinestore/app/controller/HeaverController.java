package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.request.HeaverRequestDto;
import com.onlinestore.app.dto.response.HeaverResponseDto;
import com.onlinestore.app.model.Heaver;
import com.onlinestore.app.service.HeaverService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Heaver controller.
 */
@RestController
@RequestMapping("/heavers")
public class HeaverController {

    private final Mapper mapper;

    private final HeaverService heaverService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Heaver controller.
     *
     * @param mapper                 the mapper
     * @param heaverService          the heaver service
     * @param localizedMessageSource the localized message source
     */
    public HeaverController(final Mapper mapper,
                            final HeaverService heaverService,
                            final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.heaverService = heaverService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<HeaverResponseDto>> getAll() {
        final List<Heaver> heavers = heaverService.findAll();
        final List<HeaverResponseDto> heaverResponseDtoList = heavers.stream()
                .map((heaver) -> mapper.map(heaver, HeaverResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(heaverResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<HeaverResponseDto> getOne(@PathVariable Long id) {
        final HeaverResponseDto heaverResponseDto;
        heaverResponseDto = mapper.map(heaverService.findById(id), HeaverResponseDto.class);
        return new ResponseEntity<>(heaverResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param heaverRequestDto the heaver request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<HeaverResponseDto> save(@RequestBody HeaverRequestDto heaverRequestDto) {
        heaverRequestDto.setId(null);
        final HeaverResponseDto heaverResponseDto = mapper.map(heaverService
                .save(mapper.map(heaverRequestDto, Heaver.class)), HeaverResponseDto.class);
        return new ResponseEntity<>(heaverResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param heaverRequestDto the heaver request dto
     * @param id               the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<HeaverResponseDto> update(@RequestBody HeaverRequestDto heaverRequestDto,
                                                    @PathVariable Long id) throws RuntimeException {
        if (!Objects.equals(id, heaverRequestDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.heaver.unexpectedId", new Object[]{}));
        final HeaverResponseDto heaverResponseDto = mapper.map(heaverService
                .update(mapper.map(heaverRequestDto, Heaver.class)), HeaverResponseDto.class);
        return new ResponseEntity<>(heaverResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        heaverService.deleteById(id);
    }
}
