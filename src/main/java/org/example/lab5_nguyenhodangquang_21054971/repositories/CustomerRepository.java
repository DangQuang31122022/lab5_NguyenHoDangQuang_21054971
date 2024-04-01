package org.example.lab5_nguyenhodangquang_21054971.repositories;

import org.example.lab5_nguyenhodangquang_21054971.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Optional<Customer> findCustomerByPhone(String phone);
}
