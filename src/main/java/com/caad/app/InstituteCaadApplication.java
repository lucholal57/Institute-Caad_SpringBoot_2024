package com.caad.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.caad.app.config.AppConfig;

/*
*  @Import importa el archivo de configuracion en el cual van a ir todos nuestros beans
*  @EnableConfiguration 
*  @ComponentScan(basePackages = {"com.caad.app.controller"}) ejemplo todo lo que este en ese paquete lo va a scanear autimaticamente 
*/

@SpringBootApplication
@EnableAutoConfiguration
@Import(AppConfig.class)
//@ComponentScan(basePackages = {"com.caad.app.controller"})
public class InstituteCaadApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstituteCaadApplication.class, args);
	}

}
 