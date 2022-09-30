/*
 * @Resource
 * 필드와 같은 이름을 갖는 Bean을 찾아 주입한다.
 * 
 * */
package kr.co.ezenac.beans;

import javax.annotation.Resource;

public class TestBean5 {
	
	@Resource
	private DataBean1 data1;
	@Resource
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
