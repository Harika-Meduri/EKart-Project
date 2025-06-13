package com.example.Ekart.Service;

import com.example.Ekart.Entity.Order;
import com.example.Ekart.Entity.User;
import com.example.Ekart.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findAll().stream()
                .filter(o -> o.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}

