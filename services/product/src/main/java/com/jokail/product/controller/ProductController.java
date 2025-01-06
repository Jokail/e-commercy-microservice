package com.jokail.product.controller;

import com.jokail.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest product) {
        return ResponseEntity.ok(productService.create(product));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> products
    ) {
      return ResponseEntity.ok(productService.purchaseProducts(products));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

}
