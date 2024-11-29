package com.nhom2IT8.GSMW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nhom2IT8.GSMW.repository")
@EntityScan(basePackages = "com.nhom2IT8.GSMW.entity")
public class GroceryStoreManagementWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroceryStoreManagementWebsiteApplication.class, args);
    }

}
