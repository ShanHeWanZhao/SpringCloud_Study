package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Trd
 * @date 2020-02-10 19:26
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002_APP {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7002_APP.class, args);
	}
}
