package com.trd.springcloud.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Trd
 * @date 2020-02-16 15:05
 */
@Data
@Accessors(chain = true)
public class RemoteConfig {
	private String serverPort;
	private String profiles;
	private String applicationName;
	private String eurekaHostname;
	private String eurekaServiceUrl;
}
