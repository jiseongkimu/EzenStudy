package kr.co.ezenac.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;
import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.DataBean4;

@Controller
public class TestController {
	

	// RootAppContext에서 리턴된 값이 주입됨
	@Autowired
	@Lazy // 로딩이 아니라 객체를 가져올 때 생성
	DataBean1 requestBean1;
	
	// model에 저장하지 않아도 유지됨
	@Resource(name="requestBean2")
	@Lazy
	DataBean2 requestBean2;
	
	@Autowired
	@Lazy
	DataBean3 requestBean3;
	
	@Resource(name="requestBean4")
	DataBean4 requestBean4;
	
	
	@GetMapping("/test1")
	public String test1() {
		requestBean1.setData1("문자열1");
		requestBean1.setData2("문자열2");
		
		requestBean2.setData3("문자열3");
		requestBean2.setData4("문자열4");
		
		requestBean3.setData5("문자열5");
		requestBean3.setData6("문자열6");
		
		requestBean4.setData7("문자열7");
		requestBean4.setData8("문자열8");
	
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	// public String result1() {
	public String result1(Model model) {
		System.out.printf("requestBean1.data1 : %s\n", requestBean1.getData1());
		System.out.printf("requestBean1.data2 : %s\n", requestBean1.getData2());
		System.out.printf("requestBean2.data3 : %s\n", requestBean2.getData3());
		System.out.printf("requestBean2.data4 : %s\n", requestBean2.getData4());
		System.out.printf("requestBean3.data5 : %s\n", requestBean3.getData5());
		System.out.printf("requestBean3.data6 : %s\n", requestBean3.getData6());
		System.out.printf("requestBean4.data7 : %s\n", requestBean4.getData7());
		System.out.printf("requestBean4.data8 : %s\n", requestBean4.getData8());
	
		model.addAttribute("requestBean1", requestBean1);
		// model.addAttribute("requestBean2", requestBean2); // stackOverflowError
		model.addAttribute("requestBean3", requestBean3);
		model.addAttribute("requestBean4", requestBean4);


		
		return "result1";
	}
}
