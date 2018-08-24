package com.zda.feign.mycontract;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class MyConfig {

	@Bean
	public Contract feignContract() {
		return new MyContract();
	}
}
