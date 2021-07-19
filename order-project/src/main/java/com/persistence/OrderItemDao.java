package com.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.OrderItem;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {


	@Query(value="select max(id) from orderitem", nativeQuery = true)
	public int getHighestOrderItemId();
}
