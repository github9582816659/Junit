package com.test.junit.service;

import java.util.List;

// External Service - Lets say this comes from 3rd Party API
public interface TodoService {
    public List<String> retrieveTodos(String user);
    public void deleteTodo(String todo);
}
