package kr.co.ezenac.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.ezenac.beans.JdbcBean;
import kr.co.ezenac.config.BeanConfigClass;
import kr.co.ezenac.db.JdbcDAO;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		// jdbc
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);
		
		// insert
		/*
		JdbcBean bean1 = ctx.getBean(JdbcBean.class);
		bean1.setInt_data(1);
		bean1.setStr_data("문자열1");
		dao.insert_data(bean1);
		
		JdbcBean bean2 = ctx.getBean(JdbcBean.class);
		bean2.setInt_data(2);
		bean2.setStr_data("문자열2");
		dao.insert_data(bean2);
		*/
		
		// update
		JdbcBean bean3 = ctx.getBean(JdbcBean.class);
		bean3.setInt_data(2);
		bean3.setStr_data("문자열2_수정");
		dao.update_data(bean3);
		
		// delete
		JdbcBean bean4 = ctx.getBean(JdbcBean.class);
		bean4.setInt_data(2);
		dao.delete_data(bean4.getInt_data());
		
		List<JdbcBean> list = dao.select_data();
		for(JdbcBean i : list) {
			System.out.printf("int_data : %d, str_data : %s\n", i.getInt_data(), i.getStr_data());
		}
		
		ctx.close();
	}
}
