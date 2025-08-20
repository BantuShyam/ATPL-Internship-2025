package com.aaslin.todo_springboot.service;
import java.util.List;

import com.aaslin.todo_springboot.model.Todo;

public interface TodoService {
    Todo addTodo(Todo todo);
    Todo updateStatus(Long id, String status);
    List<Todo> getAllTodos();
    List<Todo> getTodosByStatus(String status);
    List<Todo> getTodosByDateRange(java.time.LocalDateTime start, java.time.LocalDateTime end);
    List<Todo> getWeeklyTodos();
    List<Todo> getMonthlyTodos();
}
