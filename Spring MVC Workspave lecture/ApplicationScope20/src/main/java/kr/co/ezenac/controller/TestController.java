package kr.co.ezenac.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;
import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.DataBean4;

@Controller
public class TestController {

	@Autowired
	DataBean1 applicationBean1;
	
	@Resource(name="applicationBean2")
	DataBean2 applicationBean2;
	
	@Autowired
	DataBean3 applicationBean3;
	
	@Resource(name="applicationBean4")
	DataBean4 applicationBean4;
	
	@GetMapping("/test1")
	public String test1() {
		applicationBean1.setData1("data1");
		applicationBean1.setData2("data2");
		
		applicationBean2.setData3("data3");
		applicationBean2.setData4("data4");
		
		applicationBean3.setData5("data5");
		applicationBean3.setData6("data6");
		
		applicationBean4.setData7("data7");
		applicationBean4.setData8("data8");
		
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request, Model model) {
		System.out.printf("applicationBean1.data1 : %s\n", applicationBean1.getData1());
		System.out.printf("applicationBean1.data2 : %s\n", applicationBean1.getData2());
		System.out.printf("applicationBean2.data3 : %s\n", applicationBean2.getData3());
		System.out.printf("applicationBean2.data4 : %s\n", applicationBean2.getData4());
		System.out.printf("applicationBean3.data5 : %s\n", applicationBean3.getData5());
		System.out.printf("applicationBean3.data6 : %s\n", applicationBean3.getData6());
		System.out.printf("applicationBean4.data7 : %s\n", applicationBean4.getData7());
		System.out.printf("applicationBean4.data8 : %s\n", applicationBean4.getData8());
		
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("applicationBean1", applicationBean1);
		servletContext.setAttribute("applicationBean2", applicationBean2);
		//servletContext.setAttribute("applicationBean3", applicationBean3);
		model.addAttribute("applicationBean3", applicationBean3);
		servletContext.setAttribute("applicationBean4", applicationBean4);
		return "result1";
	}
}
