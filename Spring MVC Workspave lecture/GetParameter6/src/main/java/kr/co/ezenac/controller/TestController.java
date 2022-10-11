package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

		for (String str1 : data3) {
			System.out.println("data3 : " + str1);
		}

		return "result";
	}

	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		// 출력을 하기 전에 데이터 검증을 할 필요가 있다?

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

		if (data3 != null) {
			for (String str1 : data3) {
				System.out.println("data3 : " + str1);
			}
		}
		return "result";
	}

	// WebRequest : HttpServletRequest의 기능을 확장
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String[] data3 = request.getParameterValues("data3");

		// 출력을 하기 전에 데이터 검증을 할 필요가 있다?

		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);

		for (String str1 : data3) {
			System.out.println("data3 : " + str1);
		}

		return "result";
	}
	
	// @PathVariable
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1, 
						@PathVariable int data2, 
						@PathVariable int data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		return "result";
	}
	
	// @RequestParam
	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int[] data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for(int a1 : data3)
			System.out.println("data3 : " + a1);
		
		return "result";
	}
	 
	// @RequestParam(value="기존 변수명") 타입 이름
	// 많이 쓰진 않으나 필요한 경우 : 변수 이름 사용자 정의
	@GetMapping("/test6")
	public String test6(@RequestParam(value = "data1") int value1,
						@RequestParam(value = "data2") int value2,
						@RequestParam(value = "data3") int[] value3) {
		System.out.println("data1 : " + value1);
		System.out.println("data2 : " + value2);
		for(int a1 : value3)
			System.out.println("data3 : " + a1);
		
		return "result";
	}
	
	@GetMapping("/test7")
	public String test7(@RequestParam int data1,
						@RequestParam(required = false) String data2) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		return "result";
	}
}
