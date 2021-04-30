package dev.rokas.task.backend;

import dev.rokas.task.backend.api.v1.controllers.Controller;
import dev.rokas.task.backend.api.v1.model.json.request.PriceRequest;
import dev.rokas.task.backend.api.v1.repositories.PriceRepository;
import dev.rokas.task.backend.api.v1.repositories.ProductRepository;
import dev.rokas.task.backend.api.v1.services.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RentInformationApplicationTests {

    @Mock
    private PriceRepository priceRepository;

    @Autowired
    private ProductRepository productRepository;

    private Controller controller;

    @BeforeEach
    public void setup() {
        Mockito.when(priceRepository.getInitialCharge(4L)).thenReturn(Optional.of(17d));
        Mockito.when(priceRepository.getInitialCharge(5L)).thenReturn(Optional.of(35d));
        Mockito.when(priceRepository.getValueByCommitment(5L, 6)).thenReturn(Optional.of(25d));

        controller = new Controller(new ProductServiceImpl(productRepository, priceRepository));
    }

    @Test
    @DisplayName("Price calculation test. Skateboard example")
    public void testPriceCalculationOculus() {
        PriceRequest priceRequest = PriceRequest.builder()
                .id(5L)
                .commitment(6)
                .returnMonths(2)
                .build();

        Assertions.assertEquals(controller.getPrice(priceRequest), 105d);
    }

    @Test
    @DisplayName("Price calculation test. Roller-blades example")
    public void testPriceCalculationNintendo() {
        PriceRequest priceRequest = PriceRequest.builder()
                .id(4L)
                .returnMonths(7)
                .build();

        Assertions.assertEquals(controller.getPrice(priceRequest), 136d);
    }

}
