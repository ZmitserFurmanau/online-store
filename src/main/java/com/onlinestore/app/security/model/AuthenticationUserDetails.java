package com.onlinestore.app.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;


/**
 * The type Authentication user details.
 */
public class AuthenticationUserDetails implements UserDetails {

    private final Long id;

    private final String username;

    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    /**
     * Instantiates a new Authentication user details.
     *
     * @param id          the id
     * @param username    the username
     * @param password    the password
     * @param authorities the authorities
     */
    public AuthenticationUserDetails(final Long id,
                                     final String username,
                                     final String password,
                                     final Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AuthenticationUserDetails)) return false;
        AuthenticationUserDetails that = (AuthenticationUserDetails) object;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(username, that.username) &&
                Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), username, getPassword());
    }
}