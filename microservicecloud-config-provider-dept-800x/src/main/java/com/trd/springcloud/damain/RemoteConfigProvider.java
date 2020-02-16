package com.trd.springcloud.damain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Trd
 * @date 2020-02-16 16:26
 */
@Data
@Accessors(chain = true)
public class RemoteConfigProvider {
	private String serverPort;
	private String applicationName;
	private String databaseUrl;
	private String eurekaInstanceId;
	private String typeAliasPackage;
	private String profiles;
	private String infoAppName;
}
