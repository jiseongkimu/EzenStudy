package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.DataBean2;

@Configuration
@ComponentScan(basePackages="kr.co.ezenac.beans")
public class RootAppContext {
	
	// 요청을 받으면 자동으로 주입됨
	@Bean
	@RequestScope
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2") // 이름을 미리 정하면 컨트롤러에서 @resource
	@RequestScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
}
