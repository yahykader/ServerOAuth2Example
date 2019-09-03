package org.Kader.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer  {
   
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		
		security.checkTokenAccess("permitAll()");
		  
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients 
				.inMemory()
				.withClient("web")
				.secret(passwordEncoder.encode("webpass"))
				.scopes("READ","WRITE")
				.authorizedGrantTypes("password","authorization_code");
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
		
	}

}
