package com.test.junit.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void listSizeTest() {
        // given
        List list = mock(List.class);

        // when
        when(list.size()).thenReturn(2);

        // then
        assertEquals(2, list.size());

    }

    @Test
    void listSizeRandomTest() {
        // given
        List list = mock(List.class);

        // when
        when(list.size()).thenReturn(2).thenReturn(3);

        // then
        assertEquals(2, list.size());
        assertEquals(3, list.size());

    }

    @Test
    void listGetTest() {
        // given
        List list = mock(List.class);

        // when
        when(list.get(0)).thenReturn("Rahul");

        // then
        assertEquals("Rahul", list.get(0));

        // then
        // mock return null as default if we don't tell what to do
        assertEquals(null, list.get(1));

        // ant matcher
        when(list.get(anyInt())).thenReturn("Rahul");
        assertEquals("Rahul", list.get(1));

        // exception
        when(list.get(anyInt())).thenThrow(new RuntimeException("Error while calling list get method"));

        Assertions.assertThrows(RuntimeException.class, () -> {
            list.get(0);
        });

    }
}
