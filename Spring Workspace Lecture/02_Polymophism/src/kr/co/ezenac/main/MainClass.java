package kr.co.ezenac.main;

import kr.co.ezenac.beans.HelloWorld;
import kr.co.ezenac.beans.HelloWorldEn;
import kr.co.ezenac.beans.HelloWorldKo;

public class MainClass {
	public static void main(String[] args) {
		HelloWorld hello1 = new HelloWorldKo();
		HelloWorld hello2 = new HelloWorldKo();
		HelloWorld hello3 = new HelloWorldEn();
		HelloWorld hello4 = new HelloWorldEn();
		callMethod(hello1);
		callMethod(hello2);
		callMethod(hello3);
		callMethod(hello4);	
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
