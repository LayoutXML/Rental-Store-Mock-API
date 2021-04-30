package dev.rokas.task.backend.api.v1.controllers;

import dev.rokas.task.backend.api.v1.model.json.request.PriceRequest;
import dev.rokas.task.backend.api.v1.model.json.response.ProductDetailView;
import dev.rokas.task.backend.api.v1.model.json.response.ProductView;
import dev.rokas.task.backend.api.v1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductView> getProductList() {
        return productService.getProductList();
    }

    @GetMapping("/details")
    public ProductDetailView getProductDetails(@RequestParam Long id) {
        return productService.getProductDetails(id);
    }

    @GetMapping("/delete")
    public void deleteProduct(@Valid @NotNull @RequestParam Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/price")
    public Double getPrice(@Valid @RequestBody PriceRequest priceRequest) {
        return productService.getPrice(priceRequest);
    }
}
