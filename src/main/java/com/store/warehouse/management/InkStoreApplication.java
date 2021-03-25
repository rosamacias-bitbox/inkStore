package com.store.warehouse.management;

import com.store.warehouse.management.dto.UserDTO;
import com.store.warehouse.management.model.UserRole;
import com.store.warehouse.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class InkStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InkStoreApplication.class, args);
	}

	@Autowired
	private UserService userService;

	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;



	@Override
	public void run(String... args) throws Exception {

		/** Adding a user for prototyping */
		UserDTO user1 = new UserDTO();
		user1.setFirstname("-");
		user1.setLastname("-");
		user1.setUsername("user1");
		user1.setPassword(new BCryptPasswordEncoder().encode("user1"));
		user1.setEmail("rosmacias@gmail.com");

		userService.createUser(user1, UserRole.USER);
	}
}
