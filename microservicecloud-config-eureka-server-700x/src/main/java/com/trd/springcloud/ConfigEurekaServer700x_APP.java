package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Trd
 * @date 2020-02-16 14:56
 */
@SpringBootApplication
// 开启eureka server的服务
@EnableEurekaServer
public class ConfigEurekaServer700x_APP {
	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaServer700x_APP.class, args);
	}
}
