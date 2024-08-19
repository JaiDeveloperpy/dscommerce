package com.swdev.dscommerce.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.swdev.dscommerce.dto.ProductDTO;
import com.swdev.dscommerce.entities.Product;
import com.swdev.dscommerce.repositories.ProductRepository;
import com.swdev.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findBAll(Pageable pageable){
        return service.findAll(pageable); // Test
    }

    @PostMapping
    public ProductDTO insert (@RequestBody ProductDTO dto){
        return service.insert(dto);
    }
}
