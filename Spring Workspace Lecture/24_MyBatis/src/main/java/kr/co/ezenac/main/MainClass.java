package kr.co.ezenac.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.ezenac.beans.JdbcBean;
import kr.co.ezenac.config.BeanConfigClass;
import kr.co.ezenac.mapper.MapperInterface;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		MapperInterface mapper = ctx.getBean("test_mapper", MapperInterface.class);
		/*
		JdbcBean bean2 = new JdbcBean();
		bean2.setInt_data(100);
		bean2.setStr_data("문자열100");
		mapper.insert(bean2);
		*/
		
		/*
		JdbcBean bean3 = new JdbcBean();
		bean3.setInt_data(100);
		bean3.setStr_data("300");
		mapper.update(bean3);
		*/
		
		JdbcBean bean4 = new JdbcBean();
		bean4.setInt_data(100);
		mapper.delete(bean4);
		
		List<JdbcBean> list1 = mapper.select_data();
		
		for(JdbcBean bean1 : list1) {
			System.out.printf("int_data : %d, str_data : %s\n", bean1.getInt_data(), bean1.getStr_data());
		}
		
		ctx.close();
	}
}
