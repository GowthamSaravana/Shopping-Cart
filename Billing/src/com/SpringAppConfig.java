package com;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class SpringAppConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver viewReslover() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	 
}
