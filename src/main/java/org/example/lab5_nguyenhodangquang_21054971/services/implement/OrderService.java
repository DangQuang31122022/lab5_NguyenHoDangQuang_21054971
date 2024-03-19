package org.example.lab5_nguyenhodangquang_21054971.services.implement;

import org.example.lab5_nguyenhodangquang_21054971.models.Order;
import org.example.lab5_nguyenhodangquang_21054971.repositories.OrderRepository;
import org.example.lab5_nguyenhodangquang_21054971.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderService implements IService<Order, Integer> {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public boolean create(Order entity) {
        try {
            orderRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Order entity) {
        try {
            orderRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Order entity) {
        try {
            orderRepository.delete(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        return orderRepository.findById(Long.valueOf(integer));
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }
}
