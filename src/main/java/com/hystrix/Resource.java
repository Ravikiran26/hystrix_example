package com.hystrix;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class Resource {
	
	@HystrixCommand(fallbackMethod = "fallbackHello")
	@GetMapping("/hello")
	public String hello() {
		
		//wrong
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("!Failed");
		}
		return "Hello world";
	}
	
	public String fallbackHello() {
		return "Fallback hello initialized";
	}
	

}
