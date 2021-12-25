package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.RoleDto;
import com.onlinestore.app.model.Role;
import com.onlinestore.app.service.RoleService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Role controller.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final Mapper mapper;

    private final RoleService roleService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new Role controller.
     *
     * @param mapper                 the mapper
     * @param roleService            the role service
     * @param localizedMessageSource the localized message source
     */
    public RoleController(final Mapper mapper,
                          final RoleService roleService,
                          final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.roleService = roleService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<RoleDto>> getAll() {
        final List<Role> roles = roleService.findAll();
        final List<RoleDto> roleDtoList = roles.stream()
                .map((role) -> mapper.map(role, RoleDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(roleDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDto> getOne(@PathVariable Long id) {
        final RoleDto roleDto = mapper.map(roleService.findById(id), RoleDto.class);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param roleDto the role dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<RoleDto> save(@Valid @RequestBody RoleDto roleDto) {
        roleDto.setId(null);
        final RoleDto responseRoleDto = mapper.map(roleService
                .save(mapper.map(roleDto, Role.class)), RoleDto.class);
        return new ResponseEntity<>(responseRoleDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param roleDto the role dto
     * @param id      the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleDto> update(@Valid @RequestBody RoleDto roleDto, @PathVariable Long id) {
        if (!Objects.equals(id, roleDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.role.unexpectedId", new Object[]{}));
        final RoleDto responseRoleDto = mapper.map(roleService
                .update(mapper.map(roleDto, Role.class)), RoleDto.class);
        return new ResponseEntity<>(responseRoleDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
