package com.avgona.citizencrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(@Qualifier("securityDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/citizens/show-form*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/citizens/save*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/citizens/delete").hasRole("ADMIN")
                .antMatchers("/citizens/**").hasRole("EMPLOYEE")
                .antMatchers("/resources/**").permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login-form")
                    .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                    .and()
                .logout()
                .permitAll()
                    .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
