package com.trd.springcloud.dao;

import com.trd.springcloud.entities.Dept;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 14:35
 */
public interface DeptDao {
	boolean addDept(Dept dept);
	Dept findById(Integer id);
	List<Dept> findAll();
}
