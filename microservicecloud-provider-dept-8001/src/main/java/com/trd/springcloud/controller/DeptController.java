package com.trd.springcloud.controller;

import com.trd.springcloud.entities.Dept;
import com.trd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 14:51
 */
@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	// IDEA提示有两个DiscoveryClient,用@Qualifier限定一下
	@Autowired
	@Qualifier("discoveryClient")
	private DiscoveryClient client;

	@PostMapping("dept/add")
	public boolean add(@RequestBody Dept dept){
		return deptService.addDept(dept);
	}

	@GetMapping("dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return deptService.findById(id);
	}

	@GetMapping("dept/list")
	public List<Dept> list(){
		return deptService.findAll();
	}

	@GetMapping(value = "/dept/discovery")
	public Object discovery(){
		// 获取全部服务的id
		List<String> list = client.getServices();
		System.out.println("全部服务"+list);
		// 查询serviceId对应的服务实例
		List<ServiceInstance> instances = client.getInstances("microservicecloud-dept");

		for (ServiceInstance element :instances){
			System.out.println("serviceId: "+element.getServiceId());
			System.out.println("host: "+element.getHost());
			System.out.println("port: "+element.getPort());
			System.out.println("uri: "+element.getUri());
		}
		return this.client;

	}
}
