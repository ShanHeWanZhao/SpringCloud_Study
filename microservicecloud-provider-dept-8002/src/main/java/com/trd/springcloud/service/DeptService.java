package com.trd.springcloud.service;

import com.trd.springcloud.entities.Dept;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 14:48
 */
public interface DeptService {
	boolean addDept(Dept dept);
	Dept findById(Long id);
	List<Dept> findAll();
}
