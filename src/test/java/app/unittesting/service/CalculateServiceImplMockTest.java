package app.unittesting.service;

import app.unittesting.data.CalculateDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateServiceImplStubMockTest {

  @InjectMocks
  CalculateServiceImpl calculateService;

  @Mock
  CalculateDao calculateMockDao;

  @Test
  void calculateSum() {

    when(calculateMockDao.retrieveCalculations()).thenReturn(new int[] {4, 3});

    Assertions.assertEquals(7, calculateService.calculateSum());

  }

  @Test
  void calculateSum_empty() {

    when(calculateMockDao.retrieveCalculations()).thenReturn(new int[] {});

    Assertions.assertEquals(0, calculateService.calculateSum());

  }

  @Test
  void calculateSum_single() {

    when(calculateMockDao.retrieveCalculations()).thenReturn(new int[] {8});

    Assertions.assertEquals(8, calculateService.calculateSum());

  }
}
