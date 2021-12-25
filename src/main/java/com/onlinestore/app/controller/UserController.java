package com.onlinestore.app.controller;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.dto.request.UserRequestDto;
import com.onlinestore.app.dto.response.UserResponseDto;
import com.onlinestore.app.model.Role;
import com.onlinestore.app.model.User;
import com.onlinestore.app.service.UserService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final Mapper mapper;

    private final UserService userService;

    private final LocalizedMessageSource localizedMessageSource;

    /**
     * Instantiates a new User controller.
     *
     * @param mapper                 the mapper
     * @param userService            the user service
     * @param localizedMessageSource the localized message source
     */
    public UserController(final Mapper mapper,
                          final UserService userService,
                          final LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.userService = userService;
        this.localizedMessageSource = localizedMessageSource;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        final List<User> users = userService.findAll();
        final List<UserResponseDto> userResponseDtoList = users.stream()
                .map((user) -> mapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> getOne(@PathVariable Long id) {
        final UserResponseDto userResponseDto = mapper.map(userService.findById(id), UserResponseDto.class);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param userRequestDto the user request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto userRequestDto) {
        userRequestDto.setId(null);
        final UserResponseDto userResponseDto = mapper.map(userService
                .save(getUser(userRequestDto)), UserResponseDto.class);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param userRequestDto the user request dto
     * @param id             the id
     * @return the response entity
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> update(@Valid @RequestBody UserRequestDto userRequestDto,
                                                  @PathVariable Long id) throws RuntimeException {
        if (!Objects.equals(id, userRequestDto.getId()))
            throw new RuntimeException(localizedMessageSource
                    .getMessage("controller.user.unexpectedId", new Object[]{}));
        final UserResponseDto userResponseDto = mapper.map(userService
                .update(getUser(userRequestDto)), UserResponseDto.class);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    private User getUser(UserRequestDto userRequestDto) {
        final User user = mapper.map(userRequestDto, User.class);
        final Set<Role> roleSet = userRequestDto.getRoleIds().stream().map(roleId -> {
            Role role = new Role();
            role.setId(roleId);
            return role;
        }).collect(Collectors.toSet());
        user.setRoles(roleSet);
        return user;
    }
}
