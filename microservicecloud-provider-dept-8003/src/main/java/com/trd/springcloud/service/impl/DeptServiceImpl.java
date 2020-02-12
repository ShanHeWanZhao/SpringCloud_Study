package com.trd.springcloud.service.impl;

import com.trd.springcloud.dao.DeptDao;
import com.trd.springcloud.entities.Dept;
import com.trd.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-09 14:49
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptDao deptDao;

	@Override
	public boolean addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept findById(Integer id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}
}
