package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Trd
 * @date 2020-02-14 14:03
 */
@SpringBootApplication
// 开启config server端
@EnableConfigServer
public class ConfigServer3344_APP {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServer3344_APP.class, args);
	}
}
