package org.example.lab5_nguyenhodangquang_21054971.repositories;

import org.example.lab5_nguyenhodangquang_21054971.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
