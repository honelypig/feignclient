package com.zda.feignClient.agentHttpClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages={"com.zda"})
public class ClientApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApp.class).run(args);
	}
}
