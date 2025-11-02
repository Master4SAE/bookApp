package com.mybooklistApp.bookApp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mybooklistApp.bookApp.run.Location;
import com.mybooklistApp.bookApp.run.RunRepository;

@SpringBootApplication
public class BookAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BookAppApplication.class);
	public static void main(String[] args) { SpringApplication.run(BookAppApplication.class, args); }

	

}
