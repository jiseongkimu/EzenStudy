package kr.co.ezenac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.co.ezenac.beans.DataBean;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(DataBean bean, Model model) {
		bean.setA1("data2");
		
		return "test1";
	}

}
