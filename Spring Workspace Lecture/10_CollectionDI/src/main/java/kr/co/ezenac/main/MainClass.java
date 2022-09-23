package kr.co.ezenac.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.DataBean;
import kr.co.ezenac.beans.TestBean;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		line();
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		
		List<String> list1 = t1.getList1();
		for(String str : list1) {
			System.out.printf("getList1 : %s\n", str);
		}
		line();
		
		List<Integer> list2 = t1.getList2();
		for(int value : list2) {
			System.out.printf("getList2 : %d\n", value);
		}
		line();
		
		List<DataBean> list3 = t1.getList3();
		for(DataBean obj : list3) {
			System.out.printf("getList3 : %s\n", obj);
		}
		lineL();
		
		Set<String> set1 = t1.getSet1();
		for(String str: set1) {
			System.out.printf("getSet1 : %s\n", str);
		}
		line();
		
		Set<Integer> set2 = t1.getSet2();
		for(int value : set2) {
			System.out.printf("getSet2 : %d\n", value);
		}
		line();
		
		Set<DataBean> set3 = t1.getSet3();
		for(DataBean obj : set3) {
			System.out.printf("getSet3 : %s\n", obj);
		}
		lineL();
		
		Map<String, Object> map1 = t1.getMap1();
		String str = (String)map1.get("a1");
		System.out.printf("a1 : %s\n", str);
		
	}
	
	public static void line() {
		System.out.println("--------------------");
	}
	
	public static void lineL() {
		System.out.println("------------------------------------------------------------");
	}
}
