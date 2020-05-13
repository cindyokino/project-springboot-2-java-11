package com.springboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.course.entities.Order;
import com.springboot.course.repositories.OrderRepository;

@Service //registra a classe como um componente do Spring, assim pode ser injetada automaticamente com @Autowired
public class OrderService {

	@Autowired //para o Spring fazer a injecao de dependencia
	private OrderRepository repository;
	
	public List<Order> findAll() { //metodo para retornar todos os usuarios
		return repository.findAll();
	}	
	
	public Order findById(Long id) { //metodo para retornar um usuario pelo id
		Optional<Order> obj = repository.findById(id); //a operacao vai retornar um objeto do tipo Optional
		return obj.get(); //a operacao GET do OPTIONAL vai retornar um objeto do tipo USER que estiver dentro do OPTIONAL
	}
}
