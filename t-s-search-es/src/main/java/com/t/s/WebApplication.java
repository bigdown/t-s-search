package com.t.s;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.t.s")
@MapperScan(basePackages = "com.t.s.mapper")
public class WebApplication extends SpringBootServletInitializer {
    
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.web(WebApplicationType.SERVLET);
        return application.sources(WebApplication.class);
    }
    
}
