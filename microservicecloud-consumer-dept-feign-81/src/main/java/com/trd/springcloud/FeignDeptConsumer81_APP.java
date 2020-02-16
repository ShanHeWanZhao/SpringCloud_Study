package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Trd
 * @date 2020-02-09 17:05
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动该微服务时，在指定包下去加载我们定义的Feign配置类（即使用了@FeignClient注解的接口）
@EnableFeignClients("com.trd.feign.service")
@ComponentScan("com.trd")
public class FeignDeptConsumer81_APP {
	public static void main(String[] args) {
		SpringApplication.run(FeignDeptConsumer81_APP.class, args);
	}
}
