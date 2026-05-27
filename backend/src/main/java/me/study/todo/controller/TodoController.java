package me.study.todo.controller;

import me.study.todo.dto.TodoAddRespDto;
import me.study.todo.dto.TodoDeleteRespDto;
import me.study.todo.dto.TodoDoneReqDto;
import me.study.todo.dto.TodoDoneRespDto;
import me.study.todo.dto.TodoListRespDto;
import me.study.todo.dto.TodoReqDto;
import me.study.todo.dto.TodoUpdateReqDto;
import me.study.todo.dto.TodoUpdateRespDto;
import me.study.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public TodoListRespDto getTodos(
            @RequestParam Long userId,
            @RequestParam String date
    ) {
        return todoService.getTodos(userId, date);
    }

    @PostMapping
    public TodoAddRespDto addTodo(@RequestBody TodoReqDto dto) {
        return todoService.addTodo(dto);
    }

    @PatchMapping("/{todoId}/done")
    public TodoDoneRespDto updateTodoDone(
            @PathVariable Long todoId,
            @RequestBody TodoDoneReqDto dto
    ) {
        return todoService.updateTodoDone(todoId, dto);
    }

    @PutMapping("/{todoId}")
    public TodoUpdateRespDto updateTodo(
            @PathVariable Long todoId,
            @RequestBody TodoUpdateReqDto dto
    ) {
        return todoService.updateTodo(todoId, dto);
    }

    @DeleteMapping("/{todoId}")
    public TodoDeleteRespDto deleteTodo(@PathVariable Long todoId) {
        return todoService.deleteTodo(todoId);
    }
}