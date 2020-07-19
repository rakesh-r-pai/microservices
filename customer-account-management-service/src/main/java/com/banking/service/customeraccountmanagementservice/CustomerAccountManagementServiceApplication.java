package com.banking.service.customeraccountmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.banking.service.customeraccountmanagementservice")
public class CustomerAccountManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountManagementServiceApplication.class, args);
	}

}
