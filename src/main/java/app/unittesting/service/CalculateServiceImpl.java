package app.unittesting.service;

import app.unittesting.data.CalculateDao;

import java.util.Arrays;

public class CalculateServiceImpl {

    private CalculateDao calculateDao;

    public int calculateSum(int []data) {
        return data != null ? Arrays.stream(data).sum() : 0;
    }

    public int calculateSum() {
        return Arrays.stream(calculateDao.retrieveCalculations()).sum();
    }

    public void setCalculateDao(CalculateDao calculateDao) {
        this.calculateDao = calculateDao;
    }
}
