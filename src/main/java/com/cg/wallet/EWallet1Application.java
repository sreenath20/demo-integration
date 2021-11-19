package com.cg.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
*/
/*import com.cg.wallet.security.JWTAuthorizationFilter;
*/
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "eWallet API", version = "1.0", description = "Wallet Information"))

public class EWallet1Application {

	public static void main(String[] args) {
		SpringApplication.run(EWallet1Application.class, args);
	}

	/*
	 * @EnableWebSecurity
	 * 
	 * @Configuration class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable() .addFilterAfter(new JWTAuthorizationFilter(),
	 * UsernamePasswordAuthenticationFilter.class)
	 * .authorizeRequests().antMatchers(HttpMethod.POST,
	 * "/user").permitAll().anyRequest().authenticated(); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); } }
	 */
}
