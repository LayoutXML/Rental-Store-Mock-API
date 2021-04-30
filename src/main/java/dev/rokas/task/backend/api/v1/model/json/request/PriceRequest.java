package dev.rokas.task.backend.api.v1.model.json.request;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class PriceRequest {
    @NotNull
    private Long id;
    private Integer commitment;
    private Integer returnMonths;
}
