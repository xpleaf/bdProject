package cn.itcast_04_springannotation.springrunorder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class One implements ApplicationContextAware ,InitializingBean {
	
	private String text;
	
	public One(String one) {
		System.out.println(one);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
			System.out.println("setApplicationContext");
			One one = (One) context.getBean("one");
			one.setText("test text");
			System.out.println(one.getText());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
}
