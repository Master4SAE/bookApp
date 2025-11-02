package com.mybooklistApp.bookApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BookAppApplication.class);
	public static void main(String[] args) { SpringApplication.run(BookAppApplication.class, args); }

	

}
