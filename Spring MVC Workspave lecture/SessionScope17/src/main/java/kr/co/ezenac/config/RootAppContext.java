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
}
