package com.trd.feign.service;

import com.trd.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-12 11:47
 */
// 微服务的名字
@FeignClient("microservicecloud-dept")
public interface DeptClientService {
	/*
		映射路径就是调用该方法时，具体去找该服务匹配的那个路径
		请求方式再具体发送这种请求
	 */
	@PostMapping("/dept/add")
	boolean add(Dept dept);

	@GetMapping("/dept/get/{id}")
	Dept findById(@PathVariable("id") Long id);

	@GetMapping("/dept/list")
	List<Dept> findAll();
}