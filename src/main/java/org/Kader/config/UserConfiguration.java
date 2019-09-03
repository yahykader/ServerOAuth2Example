package org.Kader.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter{
	
	PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	   @Override
	public void init(AuthenticationManagerBuilder auth) throws Exception { 
		   auth.inMemoryAuthentication()
			        .withUser("yahyaoui")
			        .password(passwordEncoder.encode("kader")).roles("ADMIN","USER","MANAGER")
			        .authorities("CAN_READ","CAN_DELETE","CAN_WRITE")
			   .and()
			        .withUser("yahiaoui")
			        .password(passwordEncoder.encode("nesrine")).roles("USER")
			        .authorities("CAN_READ","CAN_WRITE");
	      
	}
}
