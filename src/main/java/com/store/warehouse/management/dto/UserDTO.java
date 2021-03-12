package com.store.warehouse.management.dto;

import com.store.warehouse.management.model.UserRole;
import com.store.warehouse.management.model.entity.Item;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private UserRole role;
    private String password;
    private String email;
    private String phoneNumber;

}
