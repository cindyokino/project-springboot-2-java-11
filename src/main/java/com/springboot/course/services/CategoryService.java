package com.springboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.course.entities.Category;
import com.springboot.course.repositories.CategoryRepository;

@Service //registra a classe como um componente do Spring, assim pode ser injetada automaticamente com @Autowired
public class CategoryService {

	@Autowired //para o Spring fazer a injecao de dependencia
	private CategoryRepository repository;
	
	public List<Category> findAll() { //metodo para retornar todos os usuarios
		return repository.findAll();
	}	
	
	public Category findById(Long id) { //metodo para retornar um usuario pelo id
		Optional<Category> obj = repository.findById(id); //a operacao vai retornar um objeto do tipo Optional
		return obj.get(); //a operacao GET do OPTIONAL vai retornar um objeto do tipo USER que estiver dentro do OPTIONAL
	}
}
