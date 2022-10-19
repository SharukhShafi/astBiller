package com.ast.zeus.billers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
public class SwaggerConfig{
	
	@Bean
    public OpenAPI publicApi() { 
        return new OpenAPI()
                .info(new Info().title("ASTBillerBackend API")
                        .description("This API is for Administration Activities")
                        .version("1.0")
                        .license(new License().name("Sharukh").url("sharukhon19@gmail.com")));
    }	
}
