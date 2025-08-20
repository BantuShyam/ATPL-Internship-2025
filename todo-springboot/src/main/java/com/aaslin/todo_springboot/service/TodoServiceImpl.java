package com.aaslin.todo_springboot.service;
import org.springframework.stereotype.Service;

import com.aaslin.todo_springboot.model.Todo;
import com.aaslin.todo_springboot.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateStatus(Long id, String status) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setStatus(status);
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public List<Todo> getTodosByStatus(String status) {
        return todoRepository.findByStatus(status);
    }

    @Override
    public List<Todo> getTodosByDateRange(LocalDateTime start, LocalDateTime end) {
        return todoRepository.findByCreatedAtBetween(start, end);
    }
    public List<Todo> getWeeklyTodos() {
        LocalDateTime startOfWeek = LocalDateTime.now()
                .with(java.time.DayOfWeek.MONDAY)
                .withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfWeek = LocalDateTime.now()
                .with(java.time.DayOfWeek.SUNDAY)
                .withHour(23).withMinute(59).withSecond(59);

        return getTodosByDateRange(startOfWeek, endOfWeek);
    }

    @Override
    public List<Todo> getMonthlyTodos() {
        LocalDateTime startOfMonth = LocalDateTime.now()
                .withDayOfMonth(1)
                .withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfMonth = LocalDateTime.now()
                .withDayOfMonth(LocalDateTime.now().toLocalDate().lengthOfMonth())
                .withHour(23).withMinute(59).withSecond(59);

        return getTodosByDateRange(startOfMonth, endOfMonth);
    }
}

