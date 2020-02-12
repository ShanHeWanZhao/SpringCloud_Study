package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Trd
 * @date 2020-02-12 21:45
 */
@SpringBootApplication
// 启动Hystrix的监控
@EnableHystrixDashboard
public class HystrixDashboard9001_App {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboard9001_App.class, args);
	}
}
