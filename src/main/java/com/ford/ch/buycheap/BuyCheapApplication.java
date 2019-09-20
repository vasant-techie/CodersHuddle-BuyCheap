package com.ford.ch.buycheap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class BuyCheapApplication {

    public static void main( String[] args )
    {
        SpringApplication.run( BuyCheapApplication.class, args );
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        return new MethodValidationPostProcessor();
    }
}
