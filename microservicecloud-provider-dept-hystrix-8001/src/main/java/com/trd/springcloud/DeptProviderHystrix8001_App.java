package com.trd.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Trd
 * @date 2020-02-09 14:57
 */
// mapper的接口包扫描
@MapperScan("com.trd.springcloud.dao")
@SpringBootApplication
// 启动Eureka的client端，将其注册到Eureka的server端
@EnableEurekaClient
@EnableCircuitBreaker
public class DeptProviderHystrix8001_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProviderHystrix8001_App.class,args);
	}
}
