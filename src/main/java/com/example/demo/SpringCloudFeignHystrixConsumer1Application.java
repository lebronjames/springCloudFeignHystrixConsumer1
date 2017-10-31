package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SpringCloudFeignHystrixConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignHystrixConsumer1Application.class, args);
	}
}