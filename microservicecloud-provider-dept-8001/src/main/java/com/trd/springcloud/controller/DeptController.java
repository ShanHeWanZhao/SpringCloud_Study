package com.trd.springcloud.controller;

import com.trd.springcloud.entities.Dept;
import com.trd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 14:51
 */
@RestController
public class DeptController {

	@Autowired
	DeptService deptService;

	@PostMapping("dept/add")
	public boolean add(@RequestBody Dept dept){
		return deptService.addDept(dept);
	}

	@GetMapping("dept/get/{id}")
	public Dept get(@PathVariable("id") Integer id){
		return deptService.findById(id);
	}

	@GetMapping("dept/list")
	public List<Dept> list(){
		return deptService.findAll();
	}

}
