package com.springboot.course.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.course.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id //indica qual é a chave primaria do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) //como a chave é numerica, ela vai ser auto incrementavel no bd
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment; //Instant ao invés de Date	
	
	private Integer orderStatus;

	@ManyToOne //varias orders podem ter um mesmo cliente (ver diagrama)-RELACAO ORDER e USER
	@JoinColumn(name = "client_id")
	private User client; //ASSOCIACOES: uma Order tem um User
	
	public Order() {		
	}

	public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus); //pega um numero Inteiro interno da classe e converte para OrderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
		this.orderStatus = orderStatus.getCode(); //pega um OrderStatus e converte para um numero Inteiro
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
