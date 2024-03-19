package org.example.lab5_nguyenhodangquang_21054971.services.implement;

import org.example.lab5_nguyenhodangquang_21054971.models.Product;
import org.example.lab5_nguyenhodangquang_21054971.repositories.ProductRepository;
import org.example.lab5_nguyenhodangquang_21054971.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IService<Product, Integer> {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public boolean create(Product entity) {
        try {
            productRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Product entity) {
        try {
            productRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Product entity) {
        try {
            productRepository.delete(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
}
