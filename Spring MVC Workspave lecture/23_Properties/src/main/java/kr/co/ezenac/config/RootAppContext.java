package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;

@Configuration
@ComponentScan(basePackages="kr.co.ezenac.beans")
public class RootAppContext {
	@Bean
	@ApplicationScope
	public DataBean1 applicationBean1() {
		return new DataBean1();
	}
	
	@Bean("applicationBean2")
	@ApplicationScope
	public DataBean2 applicationBean2() {
		return new DataBean2();
	}
}
