package com.springboot.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.course.entities.Category;
import com.springboot.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource { //CategoryResource depende de CategoryService

	@Autowired //para a injecao funcionar, a classe CategoryService precisa estar registrada como um Componente do Spring
	private CategoryService service; //CategoryService é injetada automaticamente com @Autowired
	
	@GetMapping //requisicao do tipo get
	public ResponseEntity<List<Category>> findAll() { //busca todas as categorias
		List<Category> list = service.findAll();		
		return ResponseEntity.ok().body(list); //.ok retorna a resposta com sucesso no http
	}
	
	@GetMapping(value = "/{id}") //minha requisicao vai aceitar um ID dentro da URL
	public ResponseEntity<Category> findById(@PathVariable Long id) { //@PathVariable para o Spring aceitar o ID como parametro que vai na URL
		Category obj = service.findById(id); //busca por id
		return ResponseEntity.ok().body(obj);
	}
	
}
