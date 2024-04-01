package org.example.lab5_nguyenhodangquang_21054971.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

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

    public Product(String name, double price, int quantity, LocalDate date) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
