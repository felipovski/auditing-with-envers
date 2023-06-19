package com.github.felipovski.auditingwithenvers.service;

import com.github.felipovski.auditingwithenvers.dto.ProductDTO;
import com.github.felipovski.auditingwithenvers.entity.Product;
import com.github.felipovski.auditingwithenvers.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findById(Integer id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Product add(ProductDTO dto) {
        var toSave = new Product();
        toSave.setName(dto.name());
        toSave.setDescription(dto.description());
        toSave.setPrice(dto.price());

        return repository.save(toSave);
    }

    public Product update(Integer id, ProductDTO dto) {

        var toUpdate = findById(id);
        toUpdate.setName(dto.name());
        toUpdate.setPrice(dto.price());
        toUpdate.setDescription(dto.description());

        return repository.save(toUpdate);
    }

    public void delete(Integer id) {
        repository.delete(findById(id));
    }
}
