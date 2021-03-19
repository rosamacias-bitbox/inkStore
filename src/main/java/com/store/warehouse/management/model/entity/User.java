package com.store.warehouse.management.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.store.warehouse.management.model.UserRole;
import com.store.warehouse.management.security.Authority;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String firstname;

    @NotBlank
    @Size(max = 255)
    private String lastname;

    @NotBlank
    @Size(max = 255)
    private String username;

    @Enumerated (EnumType.STRING)
    private UserRole role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Item> items;

    @NotNull
    @Size(min = 4, max = 255)
    private String password;

    @NotEmpty
    @Email
    @Size(max = 255)
    @Column(unique = true)
    private String email;

    // A simple phone number checker, allowing an optional international prefix
    // plus a variable number of digits that could be separated by dashes or
    // spaces
    @Pattern(regexp = "^(\\+\\d+)?([ -]?\\d+){4,14}$", message = "{store.warehouse.phone.number.invalid}")
    private String phoneNumber;

    public User() {
    }

    public Long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new Authority(role.name()));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
