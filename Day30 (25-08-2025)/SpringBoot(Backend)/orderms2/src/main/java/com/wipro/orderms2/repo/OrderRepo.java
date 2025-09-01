package com.wipro.orderms2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.orderms2.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	List<Order> findByUserEmail(String email);
	Order findByUserEmailAndStatus(String email, String status);
}
