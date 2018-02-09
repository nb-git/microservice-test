package de.nibu.discovery.discovery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
                .requestMatchers().antMatchers("/eureka/**").and()
                .authorizeRequests()
                .antMatchers("/eureka/**").hasRole("SYSTEM")
                .anyRequest().denyAll().and()
                .httpBasic().and()
                .csrf().disable();
    }
}
