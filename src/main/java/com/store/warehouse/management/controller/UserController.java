package com.store.warehouse.management.controller;

import com.store.warehouse.management.dto.UserDTO;
import com.store.warehouse.management.model.entity.User;
import com.store.warehouse.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<UserDTO> findAll () {
        return userService.getUsers();
    }

}
