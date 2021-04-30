package dev.rokas.task.backend.api.v1.services.impl;

import dev.rokas.task.backend.api.v1.model.database.Price;
import dev.rokas.task.backend.api.v1.model.database.Product;
import dev.rokas.task.backend.api.v1.model.exceptions.InvalidRequestException;
import dev.rokas.task.backend.api.v1.model.exceptions.NotFoundException;
import dev.rokas.task.backend.api.v1.model.json.request.PriceRequest;
import dev.rokas.task.backend.api.v1.model.json.response.ProductDetailView;
import dev.rokas.task.backend.api.v1.model.json.response.ProductView;
import dev.rokas.task.backend.api.v1.repositories.PriceRepository;
import dev.rokas.task.backend.api.v1.repositories.ProductRepository;
import dev.rokas.task.backend.api.v1.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    @Override
    @Cacheable("default")
    public List<ProductView> getProductList() {
        return productRepository.findAllByRentableTrue();
    }

    @Override
    @Cacheable("default")
    public ProductDetailView getProductDetails(Long id) {
        Product product = productRepository.findById(id).orElseThrow(NotFoundException::new);

        return ProductDetailView.builder()
                .id(product.getId())
                .title(product.getTitle())
                .commitmentMonths(product.getPrices().stream()
                        .map(Price::getCommitmentMonths)
                        .map(commitment -> commitment == null ? 0 : commitment)
                        .collect(Collectors.toSet()))
                .build();
    }

    @Override
    @CacheEvict("default")
    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException();
        }
    }

    @Override
    @Cacheable("default")
    public Double getPrice(PriceRequest priceRequest) {
        if (priceRequest.getCommitment() != null && priceRequest.getCommitment() != 3 && priceRequest.getCommitment() != 6 || priceRequest.getReturnMonths() < 0) {
            throw new InvalidRequestException();
        }

        boolean defaultReturnMonthsValue = false;
        if (priceRequest.getReturnMonths() == null) {
            defaultReturnMonthsValue = true;
            priceRequest.setReturnMonths(priceRequest.getCommitment() == null ? 1 : priceRequest.getCommitment());
        }

        Double pricePerMonth = defaultReturnMonthsValue
                ? priceRepository.getValueByCommitment(priceRequest.getId(), priceRequest.getCommitment()).orElseThrow(NotFoundException::new)
                : priceRepository.getInitialCharge(priceRequest.getId()).orElseThrow(NotFoundException::new);

        Double initialCharge = priceRepository.getInitialCharge(priceRequest.getId()).orElseThrow(NotFoundException::new);

        return initialCharge + (pricePerMonth * priceRequest.getReturnMonths());
    }
}
