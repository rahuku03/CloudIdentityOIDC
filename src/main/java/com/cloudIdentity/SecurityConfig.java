package com.cloudIdentity;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import static org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	/*
	 * @Bean SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity
	 * http) { http .authorizeExchange(exchanges -> exchanges .pathMatchers("/",
	 * "/error").permitAll() .anyExchange().authenticated() )
	 * .oauth2Login(withDefaults()); return http.build(); }
	 */
	
	   private ClientRegistrationRepository clientRegistrationRepository;
	    private Environment env;

	    public SecurityConfig(ClientRegistrationRepository clientRegistrationRepository, Environment env) {
	        this.clientRegistrationRepository = clientRegistrationRepository;
	        this.env = env;
	    }
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                .anyRequest().authenticated()
	                .and()
	                .oauth2Login()
			
			  .authorizationEndpoint() .authorizationRequestResolver(new
			  CustomAuthorizationRequestResolver(
			  clientRegistrationRepository,DEFAULT_AUTHORIZATION_REQUEST_BASE_URI ));
			 ;
	    }
	}
