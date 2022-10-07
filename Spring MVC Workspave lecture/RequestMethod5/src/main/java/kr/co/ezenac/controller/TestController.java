package kr.co.ezenac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		System.out.println("test1");
		
		return "test1";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String test2() {
		System.out.println("test2");
		
		return "test2";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3_get() {
		System.out.println("test3");
		
		return "test3_get";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public String test3_post() {
		System.out.println("test3");
		
		return "test3_post";
	}
	
	@GetMapping("/test4")
	public String test4() {
		System.out.println("test4");
		
		return "test4";
	}
	
	@PostMapping("/test5")
	public String test5() {
		System.out.println("test5");
		
		return "test5";
	}
	
	@GetMapping("/test6")
	public String test6_get() {		
		return "test6_get";
	}
	
	@PostMapping("/test6")
	public String test6_post() {		
		return "test6_post";
	}
	
	@RequestMapping(value = "/test7", method= {RequestMethod.POST, RequestMethod.GET})
	public String test7() {		
		return "test7";
	}
}
