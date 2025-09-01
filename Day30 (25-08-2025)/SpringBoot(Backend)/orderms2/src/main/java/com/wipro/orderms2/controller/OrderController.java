package com.wipro.orderms2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.orderms2.entity.Order;
import com.wipro.orderms2.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	 @Autowired
	    private OrderService orderService;

	    @PostMapping
	    public Order createOrder(@RequestBody Order order) {
	        if (order.getItemsList() != null) {
	            double total = order.getItemsList().stream()
	                                .mapToDouble(i -> i.getPrice() * i.getQuantity())
	                                .sum();
	            order.setTotalPrice(total);
	            order.getItemsList().forEach(i -> i.setOrder(order));
	        }
	        order.setStatus("Pending");
	        Order savedOrder = orderService.createOrder(order);

	        
	        new Thread(() -> {
	            try {
	                Thread.sleep(5000);
	                savedOrder.setStatus("Completed");
	                orderService.updateOrder(savedOrder);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }).start();

	        return savedOrder;
	    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        order.setId(id);
        if (order.getItemsList() != null) {
            double total = order.getItemsList().stream()
                                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                                .sum();
            order.setTotalPrice(total);
            order.getItemsList().forEach(i -> i.setOrder(order));
        }
        return orderService.updateOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{email}")
    public List<Order> getOrdersByUser(@PathVariable String email) {
        return orderService.getOrdersByUser(email);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }
}
