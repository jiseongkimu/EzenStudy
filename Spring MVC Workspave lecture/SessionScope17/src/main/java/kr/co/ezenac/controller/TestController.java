package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.ezenac.beans.DataBean1;

@Controller
@SessionAttributes({"sessionBean1", "sessionBean2"})
public class TestController {
	
	@ModelAttribute("sessionBean1")
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	
	@ModelAttribute("sessionBean2")
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}

	// 1. 내부에서 세션 생성
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		HttpSession session = request.getSession(); // 세션 반환
		session.setAttribute("data1", "문자열1"); // 어디로 보냄? jsp?
		return "test1";

	}

	// 2. 매개변수로 session을 바로 받아 사용할 수도 있다.
	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data2", "문자열2");
		return "redirect:/result1";
	}

	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("data3", "문자열3");
		return "forward:/result1";
	}

	@GetMapping("/test4")
	public String test4(HttpSession session) {
		DataBean1 bean1 = new DataBean1();
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		session.setAttribute("bean1", bean1); // session에 객체 저장
		// return "test4";
		return "forward:/result2";
	}

	// @ModelAttribute를 매개변수에서 사용하려면 해당 이름에 맞는 변수가 같은 어노테이션으로 선언돼있어야 함.
	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		sessionBean1.setData1("문자열6");
		sessionBean1.setData2("문자열7");

		sessionBean2.setData1("문자열8");
		sessionBean2.setData2("문자열9");
		
		return "test5";
	}

	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("data2") != null) {
			String data2 = (String) session.getAttribute("data2");
			System.out.printf("data2 : %s\n", data2);
		}
		if (session.getAttribute("data3") != null) {
			String data3 = (String) session.getAttribute("data3");
			System.out.printf("data3 : %s\n", data3);
		}
		return "result1";
	}

	@GetMapping("/result2")
	/*
	 * public String result2(HttpSession session) { DataBean1 bean1 =
	 * (DataBean1)session.getAttribute("bean1");
	 */
	// @SessionAttribute를 통해 session 영역에 해당 이름에 맞는 bean 객체를 찾아 주입한다
	public String result2(@SessionAttribute("bean1") DataBean1 bean1) {
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		return "result2";
	}

	@GetMapping("/result3")
	public String result3(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
							@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		System.out.printf("sessionBean1.data1 : %s\n", sessionBean1.getData1());
		System.out.printf("sessionBean1.data2 : %s\n", sessionBean1.getData2());
		System.out.printf("sessionBean2.data1 : %s\n", sessionBean2.getData1());
		System.out.printf("sessionBean2.data2 : %s\n", sessionBean2.getData2());
		return "result3";
	}
}
