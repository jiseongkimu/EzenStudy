package kr.co.ezenac.beans;

import javax.annotation.Resource;

public class TestBean6 {
	
	@Resource(name="data1")
	private DataBean1 data100;
	private DataBean1 data1;
	@Resource
	private DataBean2 data200;
	
	public DataBean1 getData100() {
		return data100;
	}
	public DataBean1 getData1() {
		return data1;
	}
	public DataBean2 getData200() {
		return data200;
	}
	
}
