package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ezenac.beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");
		
		// redirect는 한 번 요청 후 서버로부터 받은 새로운 주소값을 가지고 한 번 더 요청하게 되는데 이때의 request 객체는 새로 만들어지므로 객체 유지가 안된다.
		return "redirect:/result1";
	}
	/*
	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		request.setAttribute("data1", "문자열1");

		return "forward:/result1";
	}
*/
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		return "result1";
	}
	
	
	@GetMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("data2", "문자열2");
		return "forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(HttpServletRequest request, Model model) {
		//model로 받으면 값이 null이됨. request로 받아야함. why?
		//String data2 = (String)request.getAttribute("data2");
		String data2 = (String)model.getAttribute("data2");
		System.out.printf("data2 : %s\n", data2);
		return "result2";	
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		mv.addObject("data3", "문자열3");
		mv.setViewName("forward:/result3");
		return mv;
	}
	
	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		String data3 = (String)request.getAttribute("data3");
		System.out.printf("data3 : %s\n", data3);
		return "result3";
	}
	
	@GetMapping("/test4")
	public String test4(Model model) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		model.addAttribute("bean1", bean1);
		return "forward:/result4";
	}
	
	@GetMapping("result4")
	public String result4(HttpServletRequest request) {
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		return "result4";
	}
	
	// model에 객체가 저장됐지만 getter를 통해 바로 접근 할 순 없음. 마찬가지로 request를 통해 받아야 한다?
	// @ModelAttribute 생략하면 에러남. 왜때문에? -> forward를 통해 객체를 전달하기 위해서는 명시해야함
	@GetMapping("/test5")
	public String test5(DataBean1 bean1) {
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
	public String result5(HttpServletRequest request) {
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());/*
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());*/
		return "result5";
	}

}
