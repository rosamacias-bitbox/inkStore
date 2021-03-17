package com.store.warehouse.management.controller;

import com.store.warehouse.management.dto.UserDTO;
import com.store.warehouse.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<UserDTO> findAll () {
        return userService.getUsers();
    }

    @RequestMapping("/login")
    public String login() {
         return "login";
    }

}
