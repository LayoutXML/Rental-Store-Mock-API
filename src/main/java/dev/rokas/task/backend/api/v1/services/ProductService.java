package dev.rokas.task.backend.api.v1.services;

import dev.rokas.task.backend.api.v1.model.json.request.PriceRequest;
import dev.rokas.task.backend.api.v1.model.json.response.ProductDetailView;
import dev.rokas.task.backend.api.v1.model.json.response.ProductView;

import java.util.List;

public interface ProductService {
    List<ProductView> getProductList();

    ProductDetailView getProductDetails(Long id);

    void deleteProduct(Long id);

    Double getPrice(PriceRequest priceRequest);
}
