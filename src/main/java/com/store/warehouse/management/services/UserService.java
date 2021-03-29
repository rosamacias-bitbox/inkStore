package com.store.warehouse.management.services;

import com.store.warehouse.management.dto.UserDTO;
import com.store.warehouse.management.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserDTO> getUsers();
    public Optional<UserDTO> findById(Long id);
    public Optional<UserDTO> findByUsername(String username);
    public Optional<UserDTO> findByEmail(String email);
    public void createUser(UserDTO user, UserRole roles);
    public void createUser(UserDTO user);
    void saveUser(UserDTO user);
}
