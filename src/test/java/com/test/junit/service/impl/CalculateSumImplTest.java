package com.test.junit.service.impl;

import com.test.junit.service.CalculateDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CalculateSumImplTest {

    @Mock
    CalculateDataService calculateDataService;

    @InjectMocks
    CalculateSumImpl calculateSum;

    @Test
    void testGetSum() {
        int sum = calculateSum.getSum(1, 2);
        assertEquals(3, sum);
    }

    @Test
    void testGetSumUsingDataService() {

        int numbers[] = {1,2,3};
        when(calculateDataService.retrieveAllData()).thenReturn(numbers);

        int sumUsingDataService = calculateSum.getSumUsingDataService();
        assertEquals(6, sumUsingDataService);
    }

}
