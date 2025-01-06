package com.jokail.product.mapper;

import com.jokail.product.controller.ProductPurchaseResponse;
import com.jokail.product.controller.ProductRequest;
import com.jokail.product.controller.ProductResponse;
import com.jokail.product.entity.Category;
import com.jokail.product.entity.Product;
import com.jokail.product.repository.ProductRepository;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .availableQuality(productRequest.availableQuality())
                .category(
                        Category.builder()
                                .id(productRequest.categoryId())
                                .build()
                )
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuality(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quality) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quality
        );
    }
}
