package com.trd.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Trd
 * @date 2020-02-16 16:24
 */
@MapperScan("com.trd.springcloud.dao")
@SpringBootApplication
@EnableEurekaClient
public class ConfigDept800x_APP {
	public static void main(String[] args) {
		SpringApplication.run(ConfigDept800x_APP.class, args);
	}
}
