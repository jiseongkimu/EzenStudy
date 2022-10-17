package kr.co.ezenac.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;
import kr.co.ezenac.beans.DataBean3;
import kr.co.ezenac.beans.DataBean4;

@Controller
@PropertySource(value = { "/WEB-INF/properties/data1.properties", "/WEB-INF/properties/data2.properties" })
public class TestController {

	@Value("${aaa.a1}")
	private int a1;

	@Value("${aaa.a2}")
	private String a2;

	@Value("${bbb.b1}")
	private int b1;

	@Value("${bbb.b2}")
	private String b2;
	
	@Value("${ccc.c1}")
	private int c1;
	
	@Value("${ccc.c2}")
	private String c2;
	
	@Value("${ddd.d1}")
	private int d1;
	
	@Value("${ddd.d2}")
	private String d2;
	

	@GetMapping("/test1")
	public String test1() {
		System.out.printf("aaa.a1 : %d\n", a1);
		System.out.printf("aaa.a2 : %s\n", a2);
		System.out.printf("bbb.b1 : %d\n", b1);
		System.out.printf("bbb.b2 : %s\n", b2);
		System.out.printf("ccc.c1 : %d\n", c1);
		System.out.printf("ccc.c2 : %s\n", c2);
		System.out.printf("ddd.d1 : %d\n", d1);
		System.out.printf("ddd.d2 : %s\n", d2);

		return "test1";
	}
}
