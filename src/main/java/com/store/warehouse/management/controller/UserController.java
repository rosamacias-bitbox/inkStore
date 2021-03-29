package com.store.warehouse.management.controller;

import com.store.warehouse.management.dto.ItemDTO;
import com.store.warehouse.management.dto.UserDTO;
import com.store.warehouse.management.model.entity.User;
import com.store.warehouse.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<UserDTO> findAll () {
        return userService.getUsers();
    }

    @RequestMapping("/findById")
    public ResponseEntity<UserDTO> findById(@PathParam("id") Long id) {
        return ResponseEntity.of(userService.findById(id));

    }

    @RequestMapping("/findByUsername")
    public ResponseEntity<UserDTO> findById(@PathParam("username") String username) {
        return ResponseEntity.of(userService.findByUsername(username));

    }
}
