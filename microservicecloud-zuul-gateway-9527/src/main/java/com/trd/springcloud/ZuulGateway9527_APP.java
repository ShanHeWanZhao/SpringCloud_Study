package com.trd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Trd
 * @date 2020-02-13 11:04
 */
@SpringBootApplication
// 开启Zuul的路由代理
@EnableZuulProxy
public class ZuulGateway9527_APP {
	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway9527_APP.class, args);
	}
}
