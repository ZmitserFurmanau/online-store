package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.request.SellerRequestDto;
import com.onlinestore.app.dto.response.SellerResponseDto;
import com.onlinestore.app.model.Seller;
import com.onlinestore.app.service.SellerService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Seller controller.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final Mapper mapper;

    private final SellerService sellerService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Seller controller.
     *
     * @param mapper                 the mapper
     * @param sellerService          the seller service
     * @param localizedMessageSource the localized message source
     */
    public SellerController(final Mapper mapper,
                            final SellerService sellerService,
                            final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.sellerService = sellerService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<SellerResponseDto>> getAll() {
        final List<Seller> sellers = sellerService.findAll();
        final List<SellerResponseDto> sellerResponseDtoList = sellers.stream()
                .map((seller) -> mapper.map(seller, SellerResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(sellerResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDto> getOne(@PathVariable Long id) {
        final SellerResponseDto sellerResponseDto = mapper.map(sellerService.findById(id), SellerResponseDto.class);
        return new ResponseEntity<>(sellerResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param sellerRequestDto the seller request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<SellerResponseDto> save(@RequestBody SellerRequestDto sellerRequestDto) {
        sellerRequestDto.setId(null);
        final SellerResponseDto sellerResponseDto = mapper.map(sellerService
                .save(mapper.map(sellerRequestDto, Seller.class)), SellerResponseDto.class);
        return new ResponseEntity<>(sellerResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param sellerRequestDto the seller request dto
     * @param id               the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDto> update(@RequestBody SellerRequestDto sellerRequestDto,
                                                    @PathVariable Long id) throws RuntimeException {
        if (!Objects.equals(id, sellerRequestDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.seller.unexpectedId", new Object[]{}));
        final SellerResponseDto sellerResponseDto = mapper.map(sellerService
                .update(mapper.map(sellerRequestDto, Seller.class)), SellerResponseDto.class);
        return new ResponseEntity<>(sellerResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        sellerService.deleteById(id);
    }
}
