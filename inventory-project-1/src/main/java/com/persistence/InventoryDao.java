package com.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Inventory;

@Repository
public interface InventoryDao extends JpaRepository<Inventory, Integer> {

	public Inventory findInventoryByCode(String code);
	
	@Transactional
	@Modifying
	@Query("update Inventory set quantity=:quant where id =:invid")
	public void updateQuantity(@Param("quant")int quantity , @Param("invid")int id);
}
