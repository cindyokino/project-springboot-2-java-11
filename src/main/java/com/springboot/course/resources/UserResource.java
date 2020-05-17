package com.springboot.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.course.entities.User;
import com.springboot.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //UserResource depende de UserService

	@Autowired //para a injecao funcionar, a classe UserService precisa estar registrada como um Componente do Spring
	private UserService service; //UserService é injetada automaticamente com @Autowired
	
	@GetMapping // somente "/users" retorna todos os users
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();		
		return ResponseEntity.ok().body(list); //.ok retorna a resposta com sucesso no http
	}
	
	@GetMapping(value = "/{id}") // "/users/id" retornaum user especifico -  minha requisicao vai aceitar um ID dentro da URL
	public ResponseEntity<User> findById(@PathVariable Long id) { //@PathVariable para o Spring aceitar o ID como parametro que vai na URL
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
