package com.joseneyra.sfmsbeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class SfmsbeerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfmsbeerserviceApplication.class, args);
	}
}
