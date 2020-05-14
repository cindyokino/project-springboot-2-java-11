package com.springboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.course.entities.Product;
import com.springboot.course.repositories.ProductRepository;

@Service //registra a classe como um componente do Spring, assim pode ser injetada automaticamente com @Autowired
public class ProductService {

	@Autowired //para o Spring fazer a injecao de dependencia
	private ProductRepository repository;
	
	public List<Product> findAll() { //metodo para retornar todos os usuarios
		return repository.findAll();
	}	
	
	public Product findById(Long id) { //metodo para retornar um usuario pelo id
		Optional<Product> obj = repository.findById(id); //a operacao vai retornar um objeto do tipo Optional
		return obj.get(); //a operacao GET do OPTIONAL vai retornar um objeto do tipo USER que estiver dentro do OPTIONAL
	}
}
