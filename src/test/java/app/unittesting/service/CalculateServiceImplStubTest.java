package app.unittesting.service;

import app.unittesting.data.CalculateDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateDaoStubImpl implements CalculateDao {

  @Override
  public int[] retrieveCalculations() {
    return new int[] {1, 5, 7};
  }
}

class CalculateDaoEmptyStubImpl implements CalculateDao {

  @Override
  public int[] retrieveCalculations() {
    return new int[] {};
  }
}

class CalculateDaoOneStubImpl implements CalculateDao {

  @Override
  public int[] retrieveCalculations() {
    return new int[] {6};
  }
}

class CalculateServiceImplStubTest {

  @Test
  void calculateSum() {
    CalculateServiceImpl calculateService = new CalculateServiceImpl();
    calculateService.setCalculateDao(new CalculateDaoStubImpl());

    int actualResult = calculateService.calculateSum();
    int expectedResult = 13;

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSum_empty() {
    CalculateServiceImpl calculateService = new CalculateServiceImpl();
    calculateService.setCalculateDao(new CalculateDaoEmptyStubImpl());
    int actualResult = calculateService.calculateSum();
    int expectedResult = 0;

    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  void calculateSum_single() {
    CalculateServiceImpl calculateService = new CalculateServiceImpl();
    calculateService.setCalculateDao(new CalculateDaoOneStubImpl());
    int actualResult = calculateService.calculateSum();
    int expectedResult = 6;

    Assertions.assertEquals(expectedResult, actualResult);
  }
}
