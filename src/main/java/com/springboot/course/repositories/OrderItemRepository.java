package com.springboot.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.course.entities.OrderItem;

//nao preciso usar a anotacao @Repository pois a interface UserRepository ja herda do JpaRepository (que esta registrado como um componente do String) 
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
