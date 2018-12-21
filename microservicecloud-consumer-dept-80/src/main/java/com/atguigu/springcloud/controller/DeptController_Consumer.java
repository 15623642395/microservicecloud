package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

/**
 * 该子项目是消费者，消费者是暴露给别人访问的 只调用提供放，通过RestTemplate进行rest的调用和发出,没有service层等
 * 
 * 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
 * 
 */
@RestController
public class DeptController_Consumer {
	// 最终由消费者调用提供者进行数据的增删改查
	// private static final String REST_URL_PREFIX = "http://localhost:8001";
	// http://localhost/consumer/dept/get/3通过找到eureka上的微服务真实名称找到需要访问的内容
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/dept/add") // 暴露给外面的路径
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);// 实际由消费者访问提供者的相应路径
	}

	@RequestMapping(value = "/consumer/dept/get/{id}") // 暴露给外面的路径
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);// 实际由消费者访问提供者的相应路径
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list") // 暴露给外面的路径
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);// 实际由消费者访问提供者的相应路径
	}

	/**
	 * 查看微服务信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {

		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}
}
