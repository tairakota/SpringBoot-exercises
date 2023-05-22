package com.example.lesson.Service;

import com.example.lesson.dao.ProductDao;
import com.example.lesson.ProductNotFoundException;
import com.example.lesson.record.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgProductService implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }

    @Override
    public ProductRecord findById(int id) {
        var productRecord = productDao.findById(id);
        if (productRecord == null) {
            throw new ProductNotFoundException();
        }
        return productRecord;
    }

    @Override
    public int insert(ProductRecord productRecord) {
        return productDao.insert(productRecord);
    }

    @Override
    public int update(ProductRecord productRecord) {
        return productDao.update(productRecord);
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }
}
