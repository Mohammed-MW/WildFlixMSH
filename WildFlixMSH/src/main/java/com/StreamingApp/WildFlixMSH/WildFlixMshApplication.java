package com.StreamingApp.WildFlixMSH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class WildFlixMshApplication {

	public static void main(String[] args) {
		Random random = new Random();
		SpringApplication.run(WildFlixMshApplication.class, args);
	}

}
