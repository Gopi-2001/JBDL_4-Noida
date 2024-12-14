//package com.example.demooauth2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests()
//                .requestMatchers("/", "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login()
//                .defaultSuccessUrl("/dashboard", true)
//                .userInfoEndpoint()
//                .oidcUserService(new OidcUserService());
//        return http.build();
//    }
//}


package com.example.demooauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login").permitAll()
                       // .requestMatchers("/books/**").authenticated()
                        .anyRequest().authenticated()

                )
                // Enable OAuth2 login functionality
                .oauth2Login(oauth -> oauth
                        // Redirect users to the dashboard after successful login
                        .defaultSuccessUrl("/dashboard", true)

                        // Configure the UserInfo endpoint to fetch user details
                        .userInfoEndpoint(userInfo -> userInfo
                                // Uses OidcUserService to handle OpenID Connect user info retrieval
                                .oidcUserService(new OidcUserService())
                        )
                );

        // Build and return the configured security filter chain
        return http.build();
    }

}
