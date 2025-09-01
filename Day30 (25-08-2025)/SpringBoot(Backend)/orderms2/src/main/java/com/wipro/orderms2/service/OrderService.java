package com.wipro.orderms2.service;

import java.util.List;

import com.wipro.orderms2.entity.Order;


public interface OrderService {
	
	Order createOrder(Order order);
    Order updateOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Integer id);
    List<Order> getOrdersByUser(String email);
    void deleteOrder(Integer id);

}
