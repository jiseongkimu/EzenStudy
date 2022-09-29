package kr.co.ezenac.beans;

import org.springframework.beans.factory.annotation.Required;

public class TestBean1 {
	private int data1;
	private DataBean1 data2;
	
	public int getData1() {
		return data1;
	}
	@Required
	public void setData1(int data1) {
		this.data1 = data1;
	}
	public DataBean1 getData2() {
		return data2;
	}
	public void setData2(DataBean1 data2) {
		this.data2 = data2;
	}
	
	
}
