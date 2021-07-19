package com.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {
	private int id;
	private int productId;
	private int quantity;
	private double productPrice;
	private double totalPrice;
}
