package com.zda.feignClient.agentHttpClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ClientApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApp.class).run(args);
	}
}
