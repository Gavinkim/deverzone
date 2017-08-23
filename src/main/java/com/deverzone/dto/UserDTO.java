package com.deverzone.dto;

import com.deverzone.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

/**
 * Created by gs on 2017. 8. 23..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserDTO {
    private final String username;
    private final String name;
    private final String password;
    private final String email;
    private final String phone;


    public UserDTO(
            @JsonProperty("username") String username,
            @JsonProperty("name") String name,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("phone") String phone) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setName(name);
        user.setRegister(new Date());
        user.setPhone(phone);
        return user;
    }
    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }
    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
    public Optional<String> getPhone() {
        return Optional.ofNullable(phone);
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(username, password, getAuthorities());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> "ROLE_USER");
    }

}
