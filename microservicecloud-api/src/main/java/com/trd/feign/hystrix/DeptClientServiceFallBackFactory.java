package com.trd.feign.hystrix;

import com.trd.feign.service.DeptClientService;
import com.trd.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Trd
 * @date 2020-02-12 17:27
 */
// 一定要加，将该类注入到容器中
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			@Override
			public boolean add(Dept dept) {
				return false;
			}
			// 只测试这个方法
			@Override
			public Dept findById(Long id) {
				return new Dept().setDeptno(id)
						.setDname("该deptNo没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
						.setDb_source("没有这个数据库");
			}

			@Override
			public List<Dept> findAll() {
				return null;
			}
		};
	}
}
