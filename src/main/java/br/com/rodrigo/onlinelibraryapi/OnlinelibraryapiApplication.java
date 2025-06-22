package br.com.rodrigo.onlinelibraryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlinelibraryapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinelibraryapiApplication.class, args);
	}

}
