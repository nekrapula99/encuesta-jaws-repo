package com.jaws.backendencuestajaws;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class BackendEncuestaJawsApplication extends SpringBootServletInitializer{
	

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BackendEncuestaJawsApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BackendEncuestaJawsApplication.class, args);
		System.out.println("Inicio correctamente ON!!");
	}


}

