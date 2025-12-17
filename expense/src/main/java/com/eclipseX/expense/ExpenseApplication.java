package com.eclipseX.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseApplication {

	public static void main(String[] args) {
		System.out.print("hello");
		SpringApplication.run(ExpenseApplication.class, args);
	}
}
