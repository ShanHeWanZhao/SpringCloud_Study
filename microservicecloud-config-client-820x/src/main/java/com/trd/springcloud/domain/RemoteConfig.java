package com.trd.springcloud.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Trd
 * @date 2020-02-16 13:14
 */
// 这个类的作用只是结合浏览器的json插件，查看信息更有层次结构而已
@Data
@Accessors(chain = true)
public class RemoteConfig {
	private String applicationName;
	private String eurekaServer;
	private String port;
}
