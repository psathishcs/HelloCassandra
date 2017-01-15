package org.hello.cassandra.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
@ImportResource("classpath:spring-config.xml")
public class Application {
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("org.hello.cassandra.spring.controller"))
	      .paths(PathSelectors.ant("/*"))
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "Hello World Casssandra",
	      "Some custom description of API.",
	      "API TOS",
	      "Terms of service",
	      "myeaddress@company.com",
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}
}
