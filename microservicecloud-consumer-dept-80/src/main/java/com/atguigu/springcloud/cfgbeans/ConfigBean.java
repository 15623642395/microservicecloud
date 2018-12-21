package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // springcloud ribbon是基于netflix
					// Ribbon实现的一套客户端负均衡工具，该注解开启客户端负载均衡，默认轮循
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule myRule() {
		// return new RoundRobinRule();//轮循
		// return new RandomRule();// 随机
		return new RetryRule();// 重试，默认轮循算法，当算法出错时自己切换算法，比如轮循有问题自动切换为随机
	}
}
