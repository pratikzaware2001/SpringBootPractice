package com.example.TestProject.security;

import com.example.TestProject.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity
{
    // field level injection
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    // constructor level injection
//    @Autowired
//    public SpringSecurity(UserDetailsServiceImpl userDetailsService)
//    {
//        userDetailsService=userDetailsService;
//    }

    // setter level injection
//    @Autowired
//    public void setDepenedency(UserDetailsServiceImpl userDetailsService)
//    {
//        userDetailsService=userDetailsService
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        System.out.println("Inside securityFilterChain");
        return http.authorizeHttpRequests(request -> request
                    .requestMatchers("/user/create").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    // Autowired on method here is for ensuring AuthenticationManagerBuilder dependency is injected properly
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        System.out.println("Inside configureGlobal");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
