package com.onlinestore.app.service.impl;

import com.onlinestore.app.component.LocalizedMessageSource;
import com.onlinestore.app.model.User;
import com.onlinestore.app.repository.UserRepository;
import com.onlinestore.app.service.RoleService;
import com.onlinestore.app.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final LocalizedMessageSource localizedMessageSource;

    private final RoleService roleService;

    private final UserRepository userRepository;


    /**
     * Instantiates a new User service.
     *
     * @param localizedMessageSource the localized message source
     * @param roleService            the role service
     * @param userRepository         the user repository
     */
    public UserServiceImpl(final LocalizedMessageSource localizedMessageSource,
                           final RoleService roleService,
                           final UserRepository userRepository) {
        this.localizedMessageSource = localizedMessageSource;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource
                .getMessage("error.user.notExist", new Object[]{})));
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        validate(user.getId() != null, localizedMessageSource
                .getMessage("error.user.notHaveId", new Object[]{}));
        validate(userRepository.existsByName(user.getName()), localizedMessageSource
                .getMessage("error.user.name.notUnique", new Object[]{}));
        return saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        final Long id = user.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.user.haveId", new Object[]{}));
        final User duplicateUser = userRepository.findByName(user.getName());
        final boolean isDuplicateExists = duplicateUser != null && !Objects.equals(duplicateUser.getId(), id);
        validate(isDuplicateExists, localizedMessageSource
                .getMessage("error.user.name.notUnique", new Object[]{}));
        findById(id);
        return saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        final Long id = user.getId();
        validate(id == null, localizedMessageSource
                .getMessage("error.user.haveId", new Object[]{}));
        findById(id);
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    private User saveAndFlush(User user) {
        user.getRoles().forEach(role -> {
            validate(role == null || role.getId() == null, localizedMessageSource
                    .getMessage("error.user.roles.isNull", new Object[]{}));
            role.setName(roleService.findById(role.getId()).getName());
        });
        return userRepository.saveAndFlush(user);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
