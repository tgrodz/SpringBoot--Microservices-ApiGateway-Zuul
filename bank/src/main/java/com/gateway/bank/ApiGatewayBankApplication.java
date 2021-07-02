package com.gateway.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayBankApplication.class, args);
	}

}
