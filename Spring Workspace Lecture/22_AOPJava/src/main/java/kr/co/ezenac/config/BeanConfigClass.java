package kr.co.ezenac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages= {"kr.co.ezenac.beans", "kr.co.ezenac.advisor"})
@EnableAspectJAutoProxy
public class BeanConfigClass {

		
}
