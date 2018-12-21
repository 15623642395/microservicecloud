package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 该工程为服务提供者为服务消费者提供具体的实现，服务消费者只需要调用而不需要具体的实现方式
 * 集群搭建之后发送http://eureka7003.com:7003/；http://eureka7002.com:7002/；http://eureka7001.com:7001/等都可访问
 * @author 56525
 *
 */
@SpringBootApplication
@EnableEurekaClient // 将微服务提供方注册进eureka，标注该提供方是eureka的客户端，本服务启动后会自动注册进eureka中
@EnableDiscoveryClient // 服务发现
public class DeptProvider8001_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
