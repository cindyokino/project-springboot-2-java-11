package com.springboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.course.entities.Category;

//nao preciso usar a anotacao @Repository pois a interface CategoryRepository ja herda do JpaRepository (que esta registrado como um componente do String) 
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
