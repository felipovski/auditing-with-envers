package com.github.felipovski.auditingwithenvers.controller;

import com.github.felipovski.auditingwithenvers.dto.ProductDTO;
import com.github.felipovski.auditingwithenvers.entity.Product;
import com.github.felipovski.auditingwithenvers.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity
                .ok()
                .body(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody ProductDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody ProductDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
