package com.example.Ekart.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime orderDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")  // FK will be in order_item table
    private List<OrderItem> items = new ArrayList<>();

    // Getters, Setters
}
