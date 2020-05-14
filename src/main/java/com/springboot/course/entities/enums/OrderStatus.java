package com.springboot.course.entities.enums;

public enum OrderStatus {

//vamos atribuir manualmente um valor numerico para cada tipo enumerado para evitar erros, caso novos tipos sejam adicionados entre os ja existentes por alguem no futuro
	WAITING_PAYMENT(1), 
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
//por causa do valor numerico adicionado acima (n), o Java vai exigir algumas coisas:
	private int code; //codigo do tipo enumerado
	private OrderStatus(int code) {//construtor do tipo enumerado é especial (private)
		this.code = code;
	}
	
	public int getCode() { //para o codigo ser acessivel ao mundo exterior, vou criar um metodo publico, para acessar esse codigo
		return code;
	}
	
	public static OrderStatus valueOf(int code) { //metodo estatico(nao precisa instanciar) para converter um valor numerico para um tipo enumerado
		for(OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
