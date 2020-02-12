package com.trd.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trd.springcloud.entities.Dept;
import com.trd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Trd
 * @date 2020-02-09 14:51
 */
@RestController
public class DeptHystrixProviderController {

	private DeptService deptService;

	public DeptHystrixProviderController(@Autowired DeptService deptService) {
		this.deptService = deptService;
	}

	/*
	 * 当使用使用@HystrixCommand注解时，该方法一旦抛出异常，
	 * 	就会调用fallbackMethod属性指定的方法（即熔断），
	 * 	fallbackMethod只能指定本类中的某个方法
	 */
	@GetMapping("dept/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_get")
	public Dept get(@PathVariable("id") Long id){
		Dept dept = deptService.findById(id);
		return Objects.requireNonNull(dept, "没有这个部门，测试熔断使用");
	}

	// 发生熔断后调用的方法
	public Dept processHystrix_get(Long id){
		return  new Dept().setDeptno(id).setDname("没有ID: "+id+",请重新输入")
				.setDb_source("没有对应的数据库");
	}

}
