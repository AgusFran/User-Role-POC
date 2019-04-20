package com.poc.userrole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = UserRoleApplication.class)
public class UserRoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRoleApplication.class, args);
	}

}
