package com.example.Ekart.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;



    private int quantity;
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    // Getters, Setters
}