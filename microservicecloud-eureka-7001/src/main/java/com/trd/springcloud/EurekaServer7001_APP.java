package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Trd
 * @date 2020-02-09 20:39
 */
@SpringBootApplication
// 启动Eureka的服务端，接受其它微服务的注册
@EnableEurekaServer
public class EurekaServer7001_APP {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7001_APP.class, args);
	}
}
