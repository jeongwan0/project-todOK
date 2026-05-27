package me.study.todo.repository;

import me.study.todo.domain.Dday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DdayRepository extends JpaRepository<Dday, Long> {
    List<Dday> findByUser_UserId(Long userId);
}