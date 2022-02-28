package com.example.SecurityJpa.config;

import com.example.SecurityJpa.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

@Autowired
 private MyUserDetailsService myUserDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(myUserDetailsService);

        }
        @Bean
        public PasswordEncoder getEncoder(){
            return NoOpPasswordEncoder.getInstance();
        }

        @Override
        protected void configure(HttpSecurity http) throws  Exception{
            http.authorizeRequests()
                    .antMatchers("/user").permitAll()
                  // .antMatchers("/user").hasAnyRole("USER","ADMIN")
                    //.antMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().fullyAuthenticated().and().httpBasic();
                    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                    http.cors();

        }

    }



