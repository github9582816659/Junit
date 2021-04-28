package com.test.junit.service.impl;

import com.test.junit.service.TodoService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TodoBusinessImplTest {

    // Stub TodoService
    @Test
    void testRetrieveTodosRelatedToSpring() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        List<String> dummyUser = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, dummyUser.size());
        String expected[] = {"Learn Spring", "Learn MySQL"};
        assertArrayEquals(expected, dummyUser.toArray());

    }

    // Stub TodoService
    @Test
    void testRetrieveTodosRelatedToSpring_Empty_Array() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        List<String> dummyUser = todoBusiness.retrieveTodosRelatedToSpring("Dummy1");
        assertEquals(0, dummyUser.size());

    }

    // Mock TodoService
    @Test
    void testRetrieveTodosRelatedToSpring_Mock() {

        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);


        List<String> todos = Arrays.asList("Learn HTML", "Learn CSS", "Learn Javascript", "Learn Spring", "Learn MySQL");
        when(todoService.retrieveTodos(anyString())).thenReturn(todos);


        List<String> dummyUser = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, dummyUser.size());
        String expected[] = {"Learn Spring", "Learn MySQL"};
        assertArrayEquals(expected, dummyUser.toArray());

    }


    // BDD
    @Test
    void testRetrieveTodosRelatedToSpring_BDD_Mock() {

        // Given: setup
        TodoService todoService = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        List<String> todos = Arrays.asList("Learn HTML", "Learn CSS", "Learn Javascript", "Learn Spring", "Learn MySQL");
        given(todoService.retrieveTodos(anyString())).willReturn(todos);

        // When: actual method call
        List<String> dummyUser = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        // Then: asserts
        assertEquals(2, dummyUser.size());
        String expected[] = {"Learn Spring", "Learn MySQL"};
        assertArrayEquals(expected, dummyUser.toArray());

    }

    // verify: used to verify weather mock class method is called or not, how many times called, never called
    @Test
    void testDeleteTodosRelatedToSpring_BDD_Mock() {

        // Given: setup
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        List<String> todos = Arrays.asList("Learn HTML", "Learn CSS", "Learn Javascript", "Learn Spring", "Learn MySQL");
        given(todoServiceMock.retrieveTodos(anyString())).willReturn(todos);

        // When: actual method call
        List<String> dummyUser = todoBusiness.deleteTodosRelatedToSpring("Dummy");

        // Then: asserts
        verify(todoServiceMock).deleteTodo("Learn MySQL");
        verify(todoServiceMock, times(1)).deleteTodo("Learn MySQL");
        verify(todoServiceMock, atLeast(1)).deleteTodo("Learn MySQL");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring");

    }


}
