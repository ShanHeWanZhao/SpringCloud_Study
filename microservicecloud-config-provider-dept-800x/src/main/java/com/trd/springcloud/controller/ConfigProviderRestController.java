package com.trd.springcloud.controller;

import com.trd.springcloud.damain.RemoteConfigProvider;
import com.trd.springcloud.entities.Dept;
import com.trd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-16 16:30
 */
@RestController
public class ConfigProviderRestController {
	// service层的依赖
	@Autowired
	private DeptService deptService;

	// 去出配置文件的值
	@Value("${server.port}")
	private String serverPort;
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${spring.datasource.url}")
	private String databaseUrl;
	@Value("${eureka.instance.instance-id}")
	private String eurekaInstanceId;
	@Value("${mybatis.type-aliases-package}")
	private String typeAliasPackage;
	@Value("${spring.profiles}")
	private String profiles;
	@Value("${info.app.name}")
	private String infoAppName;

	// rest测试
	@GetMapping("/config")
	public RemoteConfigProvider getConfig(){
		RemoteConfigProvider config = new RemoteConfigProvider();
		config.setApplicationName(applicationName)
				.setDatabaseUrl(databaseUrl)
				.setEurekaInstanceId(eurekaInstanceId)
				.setInfoAppName(infoAppName)
				.setProfiles(profiles)
				.setTypeAliasPackage(typeAliasPackage)
				.setServerPort(serverPort);
		return config;
	}

	// 数据库切换的测试
	@GetMapping("dept/list")
	public List<Dept> list(){
		return deptService.findAll();
	}
}
