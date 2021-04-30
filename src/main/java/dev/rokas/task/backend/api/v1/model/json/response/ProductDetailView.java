package dev.rokas.task.backend.api.v1.model.json.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class ProductDetailView {
    private Long id;
    private String title;
    private Set<Integer> commitmentMonths;
}
