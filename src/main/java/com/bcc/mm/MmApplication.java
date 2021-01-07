package com.bcc.mm;

import com.bcc.mm.service.PropertiesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MmApplication {

	public static void main(String[] args) {
		PropertiesService ps = new PropertiesService();
		SpringApplication.run(MmApplication.class, args);
	}

}
