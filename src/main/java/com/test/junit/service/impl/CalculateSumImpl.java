package com.test.junit.service.impl;

import com.test.junit.service.CalculateDataService;

public class CalculateSumImpl {

    CalculateDataService calculateDataService;

    public int getSum(int a, int b) {
        return a + b;
    }

    public int getSumUsingDataService() {
        int[] data = calculateDataService.retrieveAllData();
        int sum = 0;
        for (Integer num: data) {
            sum = sum + num;
        }
        return sum;
    }
}
