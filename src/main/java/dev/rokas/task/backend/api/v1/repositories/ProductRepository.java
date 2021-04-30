package dev.rokas.task.backend.api.v1.repositories;

import dev.rokas.task.backend.api.v1.model.database.Product;
import dev.rokas.task.backend.api.v1.model.json.response.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<ProductView> findAllByRentableTrue();
}
