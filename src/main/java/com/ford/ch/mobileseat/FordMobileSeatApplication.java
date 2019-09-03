package com.ford.ch.mobileseat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class FordMobileSeatApplication {

    public static void main( String[] args )
    {
        SpringApplication.run( FordMobileSeatApplication.class, args );
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        return new MethodValidationPostProcessor();
    }
}
