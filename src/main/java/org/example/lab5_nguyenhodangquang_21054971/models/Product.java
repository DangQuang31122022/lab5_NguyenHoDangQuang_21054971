package org.example.lab5_nguyenhodangquang_21054971.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "products")
public class Product {
    @Id @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int quantity;
    private LocalDate date;
}
