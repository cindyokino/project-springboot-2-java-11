package com.springboot.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.course.entities.User;
import com.springboot.course.repositories.UserRepository;

@Service //registra a classe como um componente do Spring, assim pode ser injetada automaticamente com @Autowired
public class UserService {

	@Autowired //para o Spring fazer a injecao de dependencia
	private UserRepository repository;
	
	public List<User> findAll() { //metodo para retornar todos os usuarios
		return repository.findAll();
	}	
	
	public User findById(Long id) { //metodo para retornar um usuario pelo id
		Optional<User> obj = repository.findById(id); //a operacao vai retornar um objeto do tipo Optional
		return obj.get(); //a operacao GET do OPTIONAL vai retornar um objeto do tipo USER que estiver dentro do OPTIONAL
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
