package com.example.legacy;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingService_getSupportedCurrenciesGeneratedTest {

    @Test
    void shouldReturnNonNullList() {
        // arrange
        var service = new OrderProcessingService();

        // act
        var result = service.getSupportedCurrencies();

        // assert
        assertNotNull(result);
    }

    @Test
    void shouldReturnImmutableList() {
        // arrange
        var service = new OrderProcessingService();

        // act
        var result = service.getSupportedCurrencies();

        // assert
        assertThrows(UnsupportedOperationException.class, () -> result.add("GBP"));
    }

    @Test
    void shouldContainUSD() {
        // arrange
        var service = new OrderProcessingService();

        // act
        var result = service.getSupportedCurrencies();

        // assert
        assertTrue(result.contains("USD"));
    }

    @Test
    void shouldContainEUR() {
        // arrange
        var service = new OrderProcessingService();

        // act
        var result = service.getSupportedCurrencies();

        // assert
        assertTrue(result.contains("EUR"));
    }

    @Test
    void shouldContainJPY() {
        // arrange
        var service = new OrderProcessingService();

        // act
        var result = service.getSupportedCurrencies();

        // assert
        assertTrue(result.contains("JPY"));
    }

    @Test
    void shouldReturnListOfSizeThree() {
        // arrange
        var service = new OrderProcessingService();

        // act
        var result = service.getSupportedCurrencies();

        // assert
        assertEquals(3, result.size());
    }
}
