package com.trd.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Trd
 * @date 2020-02-11 16:43
 */
@Configuration
public class MyRule {
	@Bean
	public IRule getMyRule(){
		return new MyRoundRobinThreeTimesRule();
	}
}
