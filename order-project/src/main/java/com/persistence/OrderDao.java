package com.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	@Query(value="select max(id) from orders", nativeQuery = true)
	public int getHighestOrderId();
}
