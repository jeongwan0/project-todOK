package me.study.todo.controller;

import me.study.todo.dto.DdayReqDto;
import me.study.todo.dto.LoginReqDto;
import me.study.todo.dto.SignupReqDto;
import me.study.todo.dto.TodoDoneReqDto;
import me.study.todo.dto.TodoReqDto;
import me.study.todo.dto.TodoUpdateReqDto;
import me.study.todo.service.AuthService;
import me.study.todo.service.DdayService;
import me.study.todo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final AuthService authService;
    private final TodoService todoService;
    private final DdayService ddayService;

    public TestController(AuthService authService, TodoService todoService, DdayService ddayService) {
        this.authService = authService;
        this.todoService = todoService;
        this.ddayService = ddayService;
    }

    @GetMapping("/test")
    public String test() {
        return "백엔드 연결 성공";
    }

    @GetMapping("/test-signup")
    public String testSignup() {
        SignupReqDto dto = new SignupReqDto();
        dto.setLoginId("test999");
        dto.setPassword("1234");
        dto.setNickname("로그인테스트");

        authService.signup(dto);
        return "회원가입 테스트 성공";
    }

    @GetMapping("/test-login")
    public String testLogin() {
        LoginReqDto dto = new LoginReqDto();
        dto.setLoginId("test123");
        dto.setPassword("1234");

        authService.login(dto);
        return "로그인 테스트 성공";
    }

    @GetMapping("/test-add-todo")
    public String testAddTodo() {
        TodoReqDto dto = new TodoReqDto();
        dto.setUserId(1L);
        dto.setDate("2026-03-11");
        dto.setContent("할 일 추가 테스트");
        dto.setDone(false);
        dto.setDisplayOrder(0);

        todoService.addTodo(dto);
        return "할 일 추가 테스트 성공";
    }

    @GetMapping("/test-done")
    public String testDone() {
        TodoDoneReqDto dto = new TodoDoneReqDto();
        dto.setDone(true);

        todoService.updateTodoDone(1L, dto);
        return "할 일 완료 수정 테스트 성공";
    }

    @GetMapping("/test-update-todo")
    public String testUpdateTodo() {
        TodoUpdateReqDto dto = new TodoUpdateReqDto();
        dto.setContent("수정된 할 일 내용");
        dto.setDisplayOrder(0);

        todoService.updateTodo(1L, dto);
        return "할 일 수정 테스트 성공";
    }

    @GetMapping("/test-delete-todo")
    public String testDeleteTodo() {
        todoService.deleteTodo(1L);
        return "할 일 삭제 테스트 성공";
    }

    @GetMapping("/test-add-dday")
    public String testAddDday() {
        DdayReqDto dto = new DdayReqDto();
        dto.setUserId(1L);
        dto.setTitle("시험");
        dto.setTargetDate("2026-11-12");

        ddayService.addDday(dto);
        return "D-day 추가 테스트 성공";
    }

    @GetMapping("/test-update-dday")
    public String testUpdateDday() {
        DdayReqDto dto = new DdayReqDto();
        dto.setTitle("수정된 시험");
        dto.setTargetDate("2026-12-01");

        ddayService.updateDday(1L, dto);
        return "D-day 수정 테스트 성공";
    }

    @GetMapping("/test-delete-dday")
    public String testDeleteDday() {
        ddayService.deleteDday(1L);
        return "D-day 삭제 테스트 성공";
    }
}