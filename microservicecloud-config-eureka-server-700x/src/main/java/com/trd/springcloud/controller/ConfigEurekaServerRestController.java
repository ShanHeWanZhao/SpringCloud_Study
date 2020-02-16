package com.trd.springcloud.controller;

import com.trd.springcloud.domain.RemoteConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Trd
 * @date 2020-02-16 15:08
 */
@RestController
public class ConfigEurekaServerRestController {
	@Value("${server.port}")
	private String serverPort;
	@Value("${spring.profiles}")
	private String profiles;
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${eureka.instance.hostname}")
	private String eurekaHostname;
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServiceUrl;

	/*
		由于eureka server会导入jackson-dataformat-xml包,而前端的request
			中Accept请求头的xml在前，所以如果不指定produces，返回的是xml格式，而不是json
	 */
	@GetMapping(value = "/config", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RemoteConfig getConfig(){
		RemoteConfig config = new RemoteConfig();
		config.setApplicationName(applicationName)
				.setEurekaHostname(eurekaHostname)
				.setEurekaServiceUrl(eurekaServiceUrl)
				.setProfiles(profiles)
				.setServerPort(serverPort);
		return config;
	}
}
