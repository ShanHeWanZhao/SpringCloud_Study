package com.trd.springcloud.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Trd
 * @date 2020-02-09 11:50
 */
@Data
@Accessors(chain = true)
public class Dept implements Serializable {


	private static final long serialVersionUID = 1L;
	/**
	 *  主键
	 */
	private Long deptno;
	/**
	 * 	部门名称
	 */
	private String dname;
	/**
	 * 数据库名称，微服务可能有多个数据库
	 */
	private String db_source;

}
