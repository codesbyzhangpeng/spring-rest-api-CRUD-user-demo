package com.zhangpeng.springbootrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/hello-world/{name}")
	public HelloWorldBean HelloWorldVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello, World of %s", name));
	}

}
