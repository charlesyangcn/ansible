package com.charlesyang.app.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@Order(2) 
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	static final String filePath = System.getProperty("java.io.tmpdir");
	static final int maxFileSize = 10 * 1024 * 1024; // 10 MB
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { 
			new HiddenHttpMethodFilter(),		//support HEAD, PUT, DELETE from html forms
			new MultipartFilter()				//translate multipart if required
		};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(filePath, maxFileSize, maxFileSize * 2, maxFileSize / 2));
	}

}
