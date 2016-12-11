package org.casadocodigo.loja.conf;

import org.casadocodigo.loja.controllers.HomeController;
import org.casadocodigo.loja.daos.ProdutoDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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
	
	/**
	 * Cria um bean do Spring responsável por configurar o arquivo de mensagens que será
	 * utilizado nas páginas do projeto
	 * @return Um bean de MessageSource com as configurações das mensagens definidas 
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
}
