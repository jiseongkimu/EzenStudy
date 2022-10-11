package kr.co.ezenac.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import kr.co.ezenac.beans.DataBean;
import kr.co.ezenac.beans.DataBean2;

@Controller
public class TestController {

	// Map과 List는 형변환이 되지 않기 때문에 무조건 String으로 받아야 한다
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3"); // data3은 중복된 변수이므로 앞의 데이터만 가져옴
		
		System.out.printf("data1 :  %s\n", data1);
		System.out.printf("data2 :  %s\n", data2);
		System.out.printf("data3 :  %s\n", data33);
		
		// List는 중복처리 가능
		for(String str : data3) {
			System.out.printf("str : %s\n", str);
		}
		
		return "result";
	}
	
	// @ModelAttribute : 자동주입(생략가능)
	@GetMapping("/test2")
	// public String test2(@ModelAttribute DataBean bean1, @ModelAttribute DataBean2 bean2) {
	public String test2(DataBean bean1, DataBean2 bean2) {
		System.out.printf("data1 : %d\n", bean1.getData1());
		System.out.printf("data2 : %d\n", bean1.getData2());
		
		for(int number1 : bean1.getData3())
			System.out.printf("data3 : %d\n", number1);
		
		System.out.printf("bean2.data1 : %d\n", bean2.getData1());
		System.out.printf("bean2.data2 : %d\n", bean2.getData2());
		
		return "result";
	}

}
