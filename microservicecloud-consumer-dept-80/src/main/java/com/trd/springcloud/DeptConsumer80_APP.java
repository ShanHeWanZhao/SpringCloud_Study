package com.trd.springcloud;

import com.trd.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Trd
 * @date 2020-02-09 17:05
 */
@SpringBootApplication
@EnableEurekaClient
// name就是注入进eureka server的eureka client的名字
@RibbonClient(name="microservicecloud-dept",configuration = MyRule.class)
public class DeptConsumer80_APP {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_APP.class, args);
	}
}
