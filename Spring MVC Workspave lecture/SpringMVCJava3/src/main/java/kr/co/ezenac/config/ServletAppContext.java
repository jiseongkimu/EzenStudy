package kr.co.ezenac.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
//Controller 어노테이션이 있는 클래스를 컨트롤러로 등록
@EnableWebMvc
@ComponentScan("kr.co.ezenac.controller")
public class ServletAppContext implements WebMvcConfigurer{
	// 컨트롤러의 메서드가 반환하는 jsp의 이름 앞뒤에 확장자를 붙인다.
}

