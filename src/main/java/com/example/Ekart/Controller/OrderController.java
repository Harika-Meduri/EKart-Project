package com.example.Ekart.Controller;

import com.example.Ekart.Entity.Order;
import com.example.Ekart.Entity.User;
import com.example.Ekart.Service.OrderService;
import com.example.Ekart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order, Authentication authentication) {
        // get the logged-in username
        String username = authentication.getName();

        // find the user entity from the username
        User user = userService.findByUsername(username);

        // attach user to order
        order.setUser(user);

        return ResponseEntity.ok(orderService.placeOrder(order));
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/my")
    public ResponseEntity<List<Order>> myOrders(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderService.getOrdersByUser(user));
    }
}

