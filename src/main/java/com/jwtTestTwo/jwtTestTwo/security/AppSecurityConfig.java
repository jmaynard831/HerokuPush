package com.jwtTestTwo.jwtTestTwo.security;

import java.util.Arrays;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import com.jwtTestTwo.jwtTestTwo.auth.ApplicationUserService;
import com.jwtTestTwo.jwtTestTwo.jwt.JwtConfig;
import com.jwtTestTwo.jwtTestTwo.jwt.JwtTokenVerifier;
import com.jwtTestTwo.jwtTestTwo.jwt.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final ApplicationUserService applicationUserService;
	private final SecretKey secretKey;
	private final JwtConfig jwtConfig;

	@Autowired
	public AppSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService,
			SecretKey secretKey, JwtConfig config) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.applicationUserService = applicationUserService;
		this.secretKey = secretKey;
		this.jwtConfig = config;
	}

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        		//.addFilterBefore(corsFilter(), SessionManagementFilter.class)
	        .cors().and()
	                .csrf().disable()
	                .sessionManagement()
	                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
	                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class)
	                .authorizeRequests()
	                .antMatchers("/","static/*", "index", "/css/*", "/js/*","swagger-ui.html").permitAll()
	                .antMatchers("/register").permitAll()
	                //Adding this comment
	                .antMatchers("/api/**").hasAnyRole(ApplicationUserRole.USER.name(), ApplicationUserRole.ADMIN.name())
	                .anyRequest()
	                .authenticated();
	    }


	@Override 
	protected void configure(AuthenticationManagerBuilder amb) throws Exception {
		amb.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token","Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;	
    }
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);
		return provider;
	}
}
