package com.storage;

import com.storage.config.DaoConfig;
import com.storage.config.MvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {DaoConfig.class, MvcConfig.class})
public class SimpleStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleStorageApplication.class, args);
	}
}
