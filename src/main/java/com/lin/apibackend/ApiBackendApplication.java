package com.lin.apibackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lin.apibackend.mapper")
@SpringBootApplication(scanBasePackages = {"com.lin.apibackend.common"})
public class ApiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBackendApplication.class, args);
	}

}
