package com.wipro.orderms2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.orderms2.entity.Order;
import com.wipro.orderms2.entity.OrderItem;
import com.wipro.orderms2.repo.OrderRepo;
import com.wipro.orderms2.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order createOrder(Order order) {
        if (order.getItemsList() != null) {
            double total = order.getItemsList().stream()
                    .mapToDouble(i -> i.getPrice() * i.getQuantity())
                    .sum();
            order.setTotalPrice(total);
            for (OrderItem item : order.getItemsList()) {
                item.setOrder(order);
            }
        }
        order.setStatus("Pending");
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepo.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setItemsList(order.getItemsList());
        if (order.getItemsList() != null) {
            double total = order.getItemsList().stream()
                    .mapToDouble(i -> i.getPrice() * i.getQuantity())
                    .sum();
            existingOrder.setTotalPrice(total);
            for (OrderItem item : order.getItemsList()) {
                item.setOrder(existingOrder);
            }
        }
        existingOrder.setStatus(order.getStatus());
        return orderRepo.save(existingOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByUser(String email) {
        return orderRepo.findByUserEmail(email);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepo.deleteById(id);
    }
}
