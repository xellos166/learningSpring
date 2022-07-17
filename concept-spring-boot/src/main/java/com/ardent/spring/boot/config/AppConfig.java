package com.ardent.spring.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ardent.spring.boot.filter.LoggingFilter;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class AppConfig {
	@Bean
	public FilterRegistrationBean<LoggingFilter> loggingFilter() {
		FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new LoggingFilter());
		registrationBean.addUrlPatterns("/api/v2/*");
		return registrationBean;
	}

	@Bean

	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {

		Contact contact = new Contact();
		contact.setEmail("wdibangshu@gmail.com");
		contact.setName("Dibangshu Waddar");
		return new OpenAPI().info(new Info().title("sample application API").version(appVersion)
				.description(appDesciption).termsOfService("http://swagger.io/terms/").contact(contact)
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}
}
