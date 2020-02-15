package com.trd.springcloud.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Trd
 * @date 2020-02-15 20:30
 */
// 这个类的作用只是结合浏览器的json插件，查看信息更有层次结构而已
@Data
@Accessors(chain = true)
public class RemoteConfig {
	private String applicationName;
	private String eurekaServer;
	private String port;
}
