package me.study.todo.service;

import me.study.todo.domain.Todo;
import me.study.todo.domain.User;
import me.study.todo.dto.TodoAddRespDto;
import me.study.todo.dto.TodoDeleteRespDto;
import me.study.todo.dto.TodoDoneReqDto;
import me.study.todo.dto.TodoDoneRespDto;
import me.study.todo.dto.TodoListRespDto;
import me.study.todo.dto.TodoReqDto;
import me.study.todo.dto.TodoRespDto;
import me.study.todo.dto.TodoUpdateReqDto;
import me.study.todo.dto.TodoUpdateRespDto;
import me.study.todo.repository.TodoRepository;
import me.study.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public TodoListRespDto getTodos(Long userId, String date) {
        LocalDate todoDate = LocalDate.parse(date);

        List<Todo> todoList = todoRepository.findByUser_UserIdAndTodoDateOrderByDisplayOrderAsc(userId, todoDate);

        List<TodoRespDto> todoRespDtoList = new ArrayList<>();

        for (Todo todo : todoList) {
            TodoRespDto dto = new TodoRespDto(
                    todo.getTodoId(),
                    todo.getContent(),
                    todo.getDone(),
                    todo.getDisplayOrder()
            );
            todoRespDtoList.add(dto);
        }

        return new TodoListRespDto(userId, date, todoRespDtoList);
    }

    public TodoAddRespDto addTodo(TodoReqDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

        Todo todo = new Todo();
        todo.setUser(user);
        todo.setTodoDate(LocalDate.parse(dto.getDate()));
        todo.setContent(dto.getContent());
        todo.setDone(dto.getDone() != null ? dto.getDone() : false);
        todo.setDisplayOrder(dto.getDisplayOrder() != null ? dto.getDisplayOrder() : 0);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoAddRespDto(
                savedTodo.getTodoId(),
                savedTodo.getContent(),
                "할 일 추가 성공"
        );
    }

    public TodoDoneRespDto updateTodoDone(Long todoId, TodoDoneReqDto dto) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 할 일입니다."));

        todo.setDone(dto.getDone() != null ? dto.getDone() : false);

        Todo savedTodo = todoRepository.save(todo);

        return new TodoDoneRespDto(
                savedTodo.getTodoId(),
                savedTodo.getDone(),
                "할 일 완료 상태 수정 성공"
        );
    }

    public TodoUpdateRespDto updateTodo(Long todoId, TodoUpdateReqDto dto) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 할 일입니다."));

        if (dto.getContent() != null) {
            todo.setContent(dto.getContent());
        }

        if (dto.getDisplayOrder() != null) {
            if (dto.getDone() != null) {
                todo.setDone(dto.getDone());
            }
            todo.setDisplayOrder(dto.getDisplayOrder());
        }

        Todo savedTodo = todoRepository.save(todo);

        return new TodoUpdateRespDto(
                savedTodo.getTodoId(),
                savedTodo.getContent(),
                savedTodo.getDisplayOrder(),
                "할 일 수정 성공"
        );
    }

    public TodoDeleteRespDto deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 할 일입니다."));

        todoRepository.delete(todo);

        return new TodoDeleteRespDto(
                todoId,
                "할 일 삭제 성공"
        );
    }
}