package app.unittesting.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateServiceImplTest {

    @Test
    void calculateSum() {
        CalculateServiceImpl calculateService = new CalculateServiceImpl();

        int actualResult = calculateService.calculateSum(new int[]{ 1, 2, 3, 4});
        int expectedResult = 10;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_null() {
        CalculateServiceImpl calculateService = new CalculateServiceImpl();

        int actualResult = calculateService.calculateSum(null);
        int expectedResult = 0;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty() {
        CalculateServiceImpl calculateService = new CalculateServiceImpl();

        int actualResult = calculateService.calculateSum(new int[]{ });
        int expectedResult = 0;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_single() {
        CalculateServiceImpl calculateService = new CalculateServiceImpl();

        int actualResult = calculateService.calculateSum(new int[]{ 5 });
        int expectedResult = 5;

        Assertions.assertEquals(expectedResult, actualResult);
    }
}