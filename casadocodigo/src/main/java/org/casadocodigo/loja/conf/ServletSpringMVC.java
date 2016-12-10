package org.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * A classe AppWebConfiguration será usada como classe de configuração do servlet do SpringMVC
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{AppWebConfiguration.class, JPAConfiguration.class};
	}
	
	/**
	 *  Define que o servlet do SpringMVC atenderá as requisições a partir da raiz do nosso projeto (/)
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
