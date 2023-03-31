package com.saintrivers.tech.firebasedemo.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

@Configuration
public class WebSecurityConfig {

    // @Bean
    // public CorsConfigurationSource corsConfiguration() {
    //     CorsConfiguration cors = new CorsConfiguration();
    //     cors.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
    //     cors.setAllowedMethods(Arrays.asList("GET"));
    //     cors.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Content-Type", "Authorization"));

    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", null);
    //     return source;
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()

                .authorizeHttpRequests(
                        req -> req
                                .requestMatchers("/api/public")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .oauth2ResourceServer(server -> server.jwt());

        return http.build();
    }
}
