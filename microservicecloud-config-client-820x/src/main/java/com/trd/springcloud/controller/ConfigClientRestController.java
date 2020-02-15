package com.trd.springcloud.controller;

import com.trd.springcloud.bean.RemoteConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Trd
 * @date 2020-02-15 13:07
 */
@RestController
public class ConfigClientRestController {

	/*
		这三个配置都在远程仓库里，用spEL表达式取出值，
			测试是否从远程仓库中读取到了配置文件
	 */
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;

	@Value("${server.port}")
	private String port;

	// 前段访问测试
	@GetMapping("config")
	public RemoteConfig getConfig(){
		RemoteConfig config = new RemoteConfig().setApplicationName(applicationName)
				.setEurekaServer(eurekaServers)
				.setPort(port);
		System.out.println(config);
		return config;
	}
}
