package com.esoft.ead.servlet1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextListener;

@SpringBootApplication
public class ServletApplication {

	// Registering Servlet
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet() , "/myServlet");
		return  bean;
	}

	// Registering Filter
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new MyFilter());
		bean.addServletRegistrationBeans(new ServletRegistrationBean[]{servletRegistrationBean()});
		return bean;
	}

	// Registering Listener
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistrationBean(){
		ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new MyServletContextListener());
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
