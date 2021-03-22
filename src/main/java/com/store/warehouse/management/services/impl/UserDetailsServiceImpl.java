package com.store.warehouse.management.services.impl;

import com.store.warehouse.management.model.entity.User;
import com.store.warehouse.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
       // User user = userRepository.findByEmail(username);
        if (user == null)
            throw new UsernameNotFoundException( username);

        return User.build(user);
    }


}