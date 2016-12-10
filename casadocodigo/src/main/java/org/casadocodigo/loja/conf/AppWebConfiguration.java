package org.casadocodigo.loja.conf;

import org.casadocodigo.loja.controllers.HomeController;
import org.casadocodigo.loja.daos.ProdutoDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc // Habilita o recurso de Web MVC do SpringMVC
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class}) // configurar o caminho (pacote) onde o SpringMVC irá encontrar os nossos controllers
public class AppWebConfiguration {
	
	/**
	 * Configura o projeto para que o SpringMVC consiga encontrar as views
	 * @return Um bean da classe InternalResourceViewResolver com as configurações defindas
	 * para que o Spring possa encontrar as views 
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver () {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
