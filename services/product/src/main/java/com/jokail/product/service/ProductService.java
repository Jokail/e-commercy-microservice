package com.jokail.product.service;

import com.jokail.product.controller.ProductPurchaseRequest;
import com.jokail.product.controller.ProductPurchaseResponse;
import com.jokail.product.controller.ProductRequest;
import com.jokail.product.controller.ProductResponse;
import com.jokail.product.exception.ProductPurchaseException;
import com.jokail.product.mapper.ProductMapper;
import com.jokail.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer create(ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests) {
        var productIds = requests
                .stream()
                .map(ProductPurchaseRequest::id)
                .collect(Collectors.toList());
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (storedProducts.size() != productIds.size()) {
            throw new ProductPurchaseException("Product not found");
        }

        var storesRequest = requests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::id))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storesRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with id " + product.getId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.quantity()));

        }
        
        return purchasedProducts;
    }

    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with the ID:: " + id));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
