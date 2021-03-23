package com.store.warehouse.management.services.impl;

import com.store.warehouse.management.dto.UserDTO;
import com.store.warehouse.management.model.entity.User;
import com.store.warehouse.management.model.UserRole;
import com.store.warehouse.management.repositories.UserRepository;
import com.store.warehouse.management.services.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        users.forEach(user -> userDTOs.add(modelMapper.map(user, UserDTO.class)));
        return userDTOs;
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));
        return Optional.of(modelMapper.map(optionalUser.get(), UserDTO.class));
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        return Optional.of(modelMapper.map(optionalUser.get(), UserDTO.class));
    }


    @Override
    public void createUser(UserDTO userDTO, UserRole role) {

        Optional<User> userOptional = Optional.ofNullable(modelMapper.map(userDTO, User.class));
        if (userOptional.isPresent())
        {
            User user = userOptional.get();
            User existingUser = userRepository.findByUsername(user.getUsername());
            if (existingUser != null){ //user already exists
                LOG.info("User [ " + user.getUsername() + " ] with such username already exists.");
            } else {
                //new user, not in the DB
                user.setRole(role);
                user = userRepository.save(user);
            }
        }
    }

    @Override
    @Transactional
    public void createUser(UserDTO userDTO) {
        this.createUser(userDTO, UserRole.USER);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        Optional<User> userOptional = Optional.ofNullable(modelMapper.map(userDTO, User.class));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            //user.setPassword(user.getPassword());
            userRepository.save(user);
        }
    }
}
