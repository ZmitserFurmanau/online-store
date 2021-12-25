package com.onlinestore.app.controller;

import com.onlinestore.app.dto.request.UserRegistrationRequestDto;
import com.onlinestore.app.dto.response.TokenResponseDto;
import com.onlinestore.app.model.Role;
import com.onlinestore.app.model.User;
import com.onlinestore.app.service.RoleService;
import com.onlinestore.app.service.UserService;
import com.onlinestore.app.service.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Authentication controller.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;

    private final RoleService roleService;

    private final TokenService tokenService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    /**
     * Instantiates a new Authentication controller.
     *
     * @param userService           the user service
     * @param roleService           the role service
     * @param tokenService          the token service
     * @param passwordEncoder       the password encoder
     * @param authenticationManager the authentication manager
     */
    public AuthenticationController(final UserService userService,
                                    final RoleService roleService,
                                    final TokenService tokenService,
                                    final PasswordEncoder passwordEncoder,
                                    final AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.roleService = roleService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authenticate user token response dto.
     *
     * @param requestDto the request dto
     * @return the token response dto
     */
    @PostMapping("/signIn")
    public TokenResponseDto authenticateUser(@RequestBody UserRegistrationRequestDto requestDto) {
        UsernamePasswordAuthenticationToken token;
        token = new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new TokenResponseDto(tokenService.generate(authentication));
    }

    /**
     * Register user user.
     *
     * @param userRegistrationRequestDto the user registration request dto
     * @return the user
     */
    @PostMapping("/signUp")
    public User registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        final User user = new User();
        user.setName(userRegistrationRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationRequestDto.getPassword()));
        final Set<Role> roles = userRegistrationRequestDto.getRoles().stream()
                .map(roleService::findByName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return userService.save(user);
    }
}
