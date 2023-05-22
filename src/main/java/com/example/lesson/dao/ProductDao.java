package com.example.lesson.dao;

import com.example.lesson.record.ProductRecord;

import java.util.List;

public interface ProductDao {
    List<ProductRecord> findAll();
    ProductRecord findById(int id);
    int insert(ProductRecord productRecord);
    int update(ProductRecord productRecord);
    int delete(int id);
}
