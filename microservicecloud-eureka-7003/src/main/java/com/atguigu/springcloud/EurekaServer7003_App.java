package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 微服务服务放注册进eureka，以后消费者通过eureka找到对应的提供者
 * 启动eureka主启动类发送http://localhost:7001/看到相应页面则成功
 * 
 * @author 56525
 *
 */
@SpringBootApplication
@EnableEurekaServer // 标注该工程是eureka服务端
public class EurekaServer7003_App {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003_App.class, args);
	}
}
