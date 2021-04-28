package com.test.junit.service.impl;

import com.test.junit.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

// Junit 4: @RunWith(MockitoJunitRunner.class) & Junit 5: @ExtendWith(SpringExtension.class)
@ExtendWith(SpringExtension.class)
class TodoBusinessImplRefactorTest {

    @Mock
    TodoService todoService;

    // This will check for TodoBusinessImpl for dependency and find TodoService then it will check weather we Mock that
    // If yes the it will inject that, this is exactly same as TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);
    @InjectMocks
    TodoBusinessImpl todoBusiness;

    // Mock TodoService
    @Test
    void testRetrieveTodosRelatedToSpring_Mock() {

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

        // Given
        List<String> todos = Arrays.asList("Learn HTML", "Learn CSS", "Learn Javascript", "Learn Spring", "Learn MySQL");
        given(todoService.retrieveTodos(anyString())).willReturn(todos);

        // When: actual method call
        List<String> dummyUser = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        // Then: asserts
        assertEquals(2, dummyUser.size());
        String expected[] = {"Learn Spring", "Learn MySQL"};
        assertArrayEquals(expected, dummyUser.toArray());

    }

    // verify
    @Test
    void testDeleteTodosRelatedToSpring_BDD_Mock() {

        // Given: setup
        List<String> todos = Arrays.asList("Learn HTML", "Learn CSS", "Learn Javascript", "Learn Spring", "Learn MySQL");
        given(todoService.retrieveTodos(anyString())).willReturn(todos);

        // When: actual method call
        List<String> dummyUser = todoBusiness.deleteTodosRelatedToSpring("Dummy");

        // Then: asserts
        verify(todoService).deleteTodo("Learn MySQL");
        verify(todoService, times(1)).deleteTodo("Learn MySQL");
        verify(todoService, atLeast(1)).deleteTodo("Learn MySQL");
        verify(todoService, never()).deleteTodo("Learn Spring");

    }


}
