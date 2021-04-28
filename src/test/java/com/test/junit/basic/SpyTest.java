package com.test.junit.basic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpyTest {

    // Mocking ArrayList class will return a Mocked ArrayList class who doesn't have any business logic

    // Spy will return actual class and we can override methods by when().thenReturn(), this class will have all the business logic

    // We dont use Spy on Projects, as we use little of actual and little of mock which makes it confusing

    @Test
    void test() {

        ArrayList mock = mock(ArrayList.class);
        ArrayList spy = Mockito.spy(ArrayList.class);

        assertEquals(0, mock.size());
        mock.add("Test");
        assertEquals(0, mock.size()); // This is mock without business logic
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());

        assertEquals(0, spy.size());
        spy.add("Test");
        assertEquals(1, spy.size()); // This is spy with business logic
        when(spy.size()).thenReturn(5); // Here it overrides the size() method
        assertEquals(5, spy.size());

    }
}

