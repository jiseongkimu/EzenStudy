package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import kr.co.ezenac.beans.DataBean1;
import kr.co.ezenac.beans.TestBean1;

public class BeanConfigClass {

	@Bean
	public TestBean1 java1() {
		return new TestBean1(200, "문자열", new DataBean1());
	}
	
	@Bean
	public TestBean1 java2() {
		TestBean1 t1 = new TestBean1();
		t1.setData1(400);
		t1.setData2("문자열4");
		t1.setData3(new DataBean1());
		
		return t1;
	}
	
}

