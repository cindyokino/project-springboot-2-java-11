package com.springboot.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.course.entities.User;
import com.springboot.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner { //CommandLineRunner implementa o método RUN abaixo

	@Autowired //o Spring vai fazer a injecao de dependencia
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception { //tudo o que for colocado aqui dentro vai ser executado ao iniciar a aplicacao

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
