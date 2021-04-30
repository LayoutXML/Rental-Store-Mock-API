package dev.rokas.task.backend.api.v1.repositories;

import dev.rokas.task.backend.api.v1.model.database.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("select p.value from Price p " +
            "where p.commitmentMonths = :commitment " +
            "and p.product.id = :productId")
    Optional<Double> getValueByCommitment(@Param("productId") Long productId, @Param("commitment") Integer commitment);

    @Query("select p.value from Price p " +
            "where p.commitmentMonths is null " +
            "and p.product.id = :productId")
    Optional<Double> getInitialCharge(@Param("productId") Long productId);
}
