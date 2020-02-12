package com.trd.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	修改RoundRobinRule源码，变成每个服务使用3次再轮询
 * @author Trd
 * @date 2020-02-11 16:45
 */
public class MyRoundRobinThreeTimesRule extends AbstractLoadBalancerRule {

	// 自定义的计数器，这个服务被选则了多少次
	private int count = 0;

	private AtomicInteger nextServerCyclicCounter;
	private static final boolean AVAILABLE_ONLY_SERVERS = true;
	private static final boolean ALL_SERVERS = false;

	private static Logger log = LoggerFactory.getLogger(MyRoundRobinThreeTimesRule.class);

	public MyRoundRobinThreeTimesRule() {
		nextServerCyclicCounter = new AtomicInteger(0);
	}

	public MyRoundRobinThreeTimesRule(ILoadBalancer lb) {
		this();
		setLoadBalancer(lb);
	}

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			log.warn("no load balancer");
			return null;
		}

		Server server = null;
		int count = 0;
		while (server == null && count++ < 10) {
			List<Server> reachableServers = lb.getReachableServers();
			List<Server> allServers = lb.getAllServers();
			int upCount = reachableServers.size();
			int serverCount = allServers.size();

			if ((upCount == 0) || (serverCount == 0)) {
				log.warn("No up servers available from load balancer: " + lb);
				return null;
			}

			int nextServerIndex = incrementAndGetModulo(serverCount);
			server = allServers.get(nextServerIndex);

			if (server == null) {
				/* Transient. */
				Thread.yield();
				continue;
			}

			if (server.isAlive() && (server.isReadyToServe())) {
				return (server);
			}

			// Next.
			server = null;
		}

		if (count >= 10) {
			log.warn("No available alive servers after 10 tries from load balancer: "
					+ lb);
		}
		return server;
	}
	// ============================= 只修改这个方法
	private int incrementAndGetModulo(int modulo) {

		int current = nextServerCyclicCounter.get();
		// 修改的部分，保证每个服务轮询3次
		count++;
		if (count > 3) {
			// total不设为0，是因为这次选择本来就会返回一次，如果为0则每个服务会多轮一次
			count = 1;
			for (; ; ) {
				int next = (current + 1) % modulo;
				if (nextServerCyclicCounter.compareAndSet(current, next))
					return next;
			}
		} else {
			return current;
		}
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
	}
}
