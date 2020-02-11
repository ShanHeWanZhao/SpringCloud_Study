package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Trd
 * @date 2020-02-10 19:26
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7003_APP {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003_APP.class, args);
	}
}
