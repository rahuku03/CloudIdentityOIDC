package com.cloudIdentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@SpringBootApplication
public class CloudIdentityOidcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudIdentityOidcApplication.class, args);
    }

    @GetMapping("/")
    public String echoTheUsersEmailAddress(Principal principal) {
		return "Hey there! Your email address is: " + principal.getName(); 
    	
    }
}