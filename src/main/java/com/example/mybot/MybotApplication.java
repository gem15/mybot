package com.example.mybot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.starter.TelegramBotInitializer;

@SpringBootApplication
public class MybotApplication {

	public static void main(String[] args) {

		SpringApplication.run(MybotApplication.class, args);
	}

}
