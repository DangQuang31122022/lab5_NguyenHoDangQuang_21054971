package org.example.lab5_nguyenhodangquang_21054971.services;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    boolean create(T entity);
    boolean update(T entity);
    boolean delete(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
}
