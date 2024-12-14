package org.gfg.JBDL4_OAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeHttpRequests(request->
                request.requestMatchers("/home/controller", "/customlogin.html").permitAll());

        httpSecurity.authorizeHttpRequests(request->
                request.anyRequest().authenticated());
        httpSecurity.oauth2Login(oauth->{
          //  oauth.loginPage("/customlogin.html");
                  oauth.defaultSuccessUrl("/success");
        });

       return httpSecurity.build();
    }
}
