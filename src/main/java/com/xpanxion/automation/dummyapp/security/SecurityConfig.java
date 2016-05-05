package com.xpanxion.automation.dummyapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.xpanxion.automation.dummyapp.service.UserDetailService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailService userDetailService;
    
    @Autowired
    private SuccessHandler successHandler;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .antMatchers("/", "/stylists", "/salons").permitAll()
                .antMatchers("/", "/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .authorizeRequests()
                .antMatchers("/stylists/**", "/salons/**").hasRole("Client")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").successHandler(successHandler)
                .permitAll()
                .and()
            .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	            .logoutSuccessUrl("/logout")
                .permitAll();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailService);
    }
}
