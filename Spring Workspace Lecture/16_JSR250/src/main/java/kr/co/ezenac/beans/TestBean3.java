/*
 * @Bean(autowire=Autowire.BY_NAME)
 * 이름을 통한 자동 주입
 * 
 * */
package kr.co.ezenac.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;

public class TestBean3 {
	private DataBean1 data1;
	private DataBean2 data2;
	
	
	public DataBean1 getData1() {
		return data1;
	}
	
	
	public void setData1(DataBean1 data1) {
		this.data1 = data1;
	}
	public DataBean2 getData2() {
		return data2;
	}
	
	public void setData2(DataBean2 data2) {
		this.data2 = data2;
	}
	
	
}
