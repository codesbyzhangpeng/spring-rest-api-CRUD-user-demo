package com.zhangpeng.springbootrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String HelloWorld() {
		return "hello, world";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean HelloworldBean() {
		return new HelloWorldBean("Hello World Bean!");
	}

}
