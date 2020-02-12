package com.trd.springcloud.controller;

import com.trd.feign.service.DeptClientService;
import com.trd.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 17:05
 */
@RestController
public class FeignConsumerController {


	/**
	 *  注入进使用了@FeignClient注解的接口，动态代理会去实现
	 */
	@Autowired
	private DeptClientService deptClientService;

	// 添加
	@RequestMapping("consumer/dept/add")
	public boolean add(Dept dept){
		System.out.println(dept);
		return deptClientService.add(dept);
	}
	// 查询一个
	@RequestMapping("consumer/dept/get/{id}")
	public Dept findById(@PathVariable("id") Long id){
		return deptClientService.findById(id);
	}
	// 查询所有
	@RequestMapping("consumer/dept/list")
	public List<Dept> findAll(){
		return deptClientService.findAll();
	}

}
