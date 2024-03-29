package org.zerock.myapp.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig 
extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExeptionIfNoHnadlerFound","true");
		
		MultipartConfigElement multipartConfig = 
				new MultipartConfigElement(
						"/Users/wisdlogos/Temp/upload/tmp",
						20971520,
						41943040,
						20971520
						);
		registration.setMultipartConfig(multipartConfig);
		
//		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}	// customizeRegistration

}	// end class
