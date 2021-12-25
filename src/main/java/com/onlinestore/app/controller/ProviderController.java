package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.request.ProviderRequestDto;
import com.onlinestore.app.dto.response.ProviderResponseDto;
import com.onlinestore.app.model.Provider;
import com.onlinestore.app.service.ProviderService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Provider controller.
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    private final Mapper mapper;

    private final ProviderService providerService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Provider controller.
     *
     * @param mapper                 the mapper
     * @param providerService        the provider service
     * @param localizedMessageSource the localized message source
     */
    public ProviderController(final Mapper mapper,
                              final ProviderService providerService,
                              final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.providerService = providerService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<ProviderResponseDto>> getAll() {
        final List<Provider> providers = providerService.findAll();
        final List<ProviderResponseDto> providerResponseDtoList = providers.stream()
                .map((provider) -> mapper.map(provider, ProviderResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(providerResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProviderResponseDto> getOne(@PathVariable Long id) {
        final ProviderResponseDto providerResponseDto;
        providerResponseDto = mapper.map(providerService.findById(id), ProviderResponseDto.class);
        return new ResponseEntity<>(providerResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param providerRequestDto the provider request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<ProviderResponseDto> save(@RequestBody ProviderRequestDto providerRequestDto) {
        providerRequestDto.setId(null);
        final ProviderResponseDto providerResponseDto;
        providerResponseDto = mapper.map(providerService
                .save(mapper.map(providerRequestDto, Provider.class)), ProviderResponseDto.class);
        return new ResponseEntity<>(providerResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param providerRequestDto the provider request dto
     * @param id                 the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProviderResponseDto> update(@RequestBody ProviderRequestDto providerRequestDto,
                                                      @PathVariable Long id) throws RuntimeException {
        if (!Objects.equals(id, providerRequestDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.provider.unexpectedId", new Object[]{}));
        final ProviderResponseDto providerResponseDto;
        providerResponseDto = mapper.map(providerService
                .update(mapper.map(providerRequestDto, Provider.class)), ProviderResponseDto.class);
        return new ResponseEntity<>(providerResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        providerService.deleteById(id);
    }
}
