package com.lin.apibackend;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lin.apibackend.mapper")
@SpringBootApplication(scanBasePackages = {"com.lin.apibackend", "com.lin.apiclientsdk"})
@EnableDubbo
public class ApiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBackendApplication.class, args);
	}

}
