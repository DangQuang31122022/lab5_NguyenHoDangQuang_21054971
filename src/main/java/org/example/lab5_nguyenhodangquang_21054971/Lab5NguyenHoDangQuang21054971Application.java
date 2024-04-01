package org.example.lab5_nguyenhodangquang_21054971;

import org.example.lab5_nguyenhodangquang_21054971.models.Product;
import org.example.lab5_nguyenhodangquang_21054971.services.implement.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Lab5NguyenHoDangQuang21054971Application {
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Lab5NguyenHoDangQuang21054971Application.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				productService.create(new Product("Laptop", 50d, 50, LocalDate.now()));
				productService.create(new Product("Desktopo", 25d, 50, LocalDate.now()));
			}
		};
	}
}
