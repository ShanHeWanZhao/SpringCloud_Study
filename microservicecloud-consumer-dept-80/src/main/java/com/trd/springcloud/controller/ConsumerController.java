package com.trd.springcloud.controller;

import com.netflix.loadbalancer.IRule;
import com.trd.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 17:05
 */
@RestController
public class ConsumerController {

//	private static final String REST_URL_PREFIX = "http://localhost:8001/";
	// 使用Ribbon，只提供applicationName,不再使用域名+端口号的固定写法了
	/*
		注意：这么写了，在之后的restTemplate调用方法时的拼接url，记得用'/'隔开，因为这种写法
			不会在下面的例子'microservicecloud-dept'之后自动加上'/'
	 */
	private static final String REST_URL_PREFIX = "http://microservicecloud-dept";

	/*
		RestTemplate访问restful风格的接口，
		（url，requestMap，Response.class）这三个参数分别代表
		REST请求地址、请求参数、http响应转换的对象
	 */
	private RestTemplate restTemplate;


	public ConsumerController(@Autowired RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * @param dept
	 * @return
	 */
	// 添加
	@RequestMapping("consumer/dept/add")
	public boolean add(Dept dept){
		System.out.println(dept);
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept, Boolean.class);
	}
	// 查询一个
	@RequestMapping("consumer/dept/get/{id}")
	public Dept add(@PathVariable("id") Long id){
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" +id, Dept.class);
	}
	// 查询所有
	@RequestMapping("consumer/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

}
