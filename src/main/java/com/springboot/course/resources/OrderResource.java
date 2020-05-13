package com.springboot.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.course.entities.Order;
import com.springboot.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource { //OrderResource depende de OrderService

	@Autowired //para a injecao funcionar, a classe OrderService precisa estar registrada como um Componente do Spring
	private OrderService service; //OrderService é injetada automaticamente com @Autowired
	
	@GetMapping //requisicao do tipo get
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();		
		return ResponseEntity.ok().body(list); //.ok retorna a resposta com sucesso no http
	}
	
	@GetMapping(value = "/{id}") //minha requisicao vai aceitar um ID dentro da URL
	public ResponseEntity<Order> findById(@PathVariable Long id) { //@PathVariable para o Spring aceitar o ID como parametro que vai na URL
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
