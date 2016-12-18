package org.casadocodigo.loja.conf;

import org.casadocodigo.loja.controllers.HomeController;
import org.casadocodigo.loja.daos.ProdutoDAO;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.infra.FileSaver;

@EnableWebMvc // Habilita o recurso de Web MVC do SpringMVC
@EnableCaching
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class, FileSaver.class}) // configurar o caminho (pacote) onde o SpringMVC irá encontrar os nossos controllers
public class AppWebConfiguration extends WebMvcConfigurerAdapter {
	
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
	
	/**
	 * Cria um bean para registrar um DateTimeFormatter padrão para o projeto, fazendo com que
	 * não haja a necessidade usar TAGs ou recursos para formatar datas nas páginas
	 * @return Um objeto FormattingConversionService com o formato a ser utilizado nas conversões
	 */
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}
	
	/**
	 * Cria um bean do Spring MultipartResolver, que é responsável
	 * por manipular os arquivos enviados ao servidor, e permitir que um upload seja feito por exemplo.
	 * Para isso utilizamos a clase StandardServletMultipartResolver.
	 * @return Uma instância da classe StandardServletMultipartResolver
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
