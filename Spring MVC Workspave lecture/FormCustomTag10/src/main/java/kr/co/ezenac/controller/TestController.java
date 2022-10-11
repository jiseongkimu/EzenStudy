package kr.co.ezenac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ezenac.beans.UserDataBean;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(UserDataBean bean) {
		bean.setUser_name("홍길동");
		bean.setUser_id("abcd");
		bean.setUser_pw("1234");
		bean.setUser_address1("주소1");
		bean.setUser_address2("주소2");
		bean.setUser_postcode("1");
		return "test1";
		
	}

}
