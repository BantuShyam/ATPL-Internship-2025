package com.aaslin.todo_springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.todo_springboot.model.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByStatus(String status);
    List<Todo> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}

