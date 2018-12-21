package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;
/**
 * 该工程为消费者根据url直接调用服务提供者
 * 1、启动提供者
 * 2、启动消费者
 * 3、发送请求
 * http://localhost/consumer/dept/get/2
 * http://localhost/consumer/dept/list
 * http://localhost/consumer/dept/add?dname=IT部
 * @author 56525
 *
 */
@SpringBootApplication
@EnableEurekaClient//标注是eureka客户端
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效，从而实现自定义负载均衡
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
