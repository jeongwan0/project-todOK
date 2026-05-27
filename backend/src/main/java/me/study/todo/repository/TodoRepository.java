package me.study.todo.repository;

import me.study.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser_UserIdAndTodoDateOrderByDisplayOrderAsc(Long userId, LocalDate todoDate);
}