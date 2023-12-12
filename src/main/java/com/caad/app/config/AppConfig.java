package com.caad.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.caad.app.controller.UserController;
import com.caad.app.repository.UserRepository;
import com.caad.app.service.user.UserMapper;
import com.caad.app.service.user.UserMapperImpl;
import com.caad.app.service.user.UserService;
import com.caad.app.service.user.UserServiceImpl;

/*
 * Class que sirve para poder sacar los @Beans que van a ser utilizados
 */

@Configuration
public class AppConfig {
	
	 /*
    Metodo para saltar el login de Swagger
    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        return http.build();
    }
    
    /*
     * Bean para hacer uso del controllador de usuarios
     */
    @Bean
    public UserController getUserController(UserService userService) {
    	return new UserController(userService);
    }
    
    /*
     * Bean para hacer uso del servico de usuarios
     */
    @Primary
    @Bean
    public UserService getUserService(UserMapper userMapper, UserRepository userRepository) {
    	return new UserServiceImpl(userMapper,userRepository);
    }
    
    @Bean
    public UserMapper getUserMapper() {
    	return new UserMapperImpl();
    }


}
