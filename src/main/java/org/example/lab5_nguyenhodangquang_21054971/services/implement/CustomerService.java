package org.example.lab5_nguyenhodangquang_21054971.services.implement;

import org.example.lab5_nguyenhodangquang_21054971.models.Customer;
import org.example.lab5_nguyenhodangquang_21054971.repositories.CustomerRepository;
import org.example.lab5_nguyenhodangquang_21054971.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements IService<Customer, Integer> {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public boolean create(Customer entity) {
        try {
            customerRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Customer entity) {
        try {
            customerRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Customer entity) {
        try {
            customerRepository.delete(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Optional<Customer> findCustomerByPhone(String phone) {
        return customerRepository.findCustomerByPhone(phone);
    }
}
