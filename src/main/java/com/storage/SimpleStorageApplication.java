package com.storage;

import com.storage.config.DaoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = DaoConfig.class)
public class SimpleStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleStorageApplication.class, args);
	}
}
