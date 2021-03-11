package com.store.warehouse.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class InkStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(InkStoreApplication.class, args);
	}

}
