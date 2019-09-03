package org.Kader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class ServerOAuth2ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerOAuth2ExampleApplication.class, args);
	}

}
