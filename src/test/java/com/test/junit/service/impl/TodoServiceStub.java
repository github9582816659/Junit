package com.test.junit.service.impl;

import com.test.junit.service.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodos(String user) {
        if (user.equals("Dummy1")) return Arrays.asList();
        return Arrays.asList("Learn HTML","Learn CSS", "Learn Javascript", "Learn Spring", "Learn MySQL");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
