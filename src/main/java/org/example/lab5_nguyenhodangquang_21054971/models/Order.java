package org.example.lab5_nguyenhodangquang_21054971.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "orders")
public class Order {
    @Id @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate orderDate;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
