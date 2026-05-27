package me.study.todo.controller;

import me.study.todo.dto.LoginReqDto;
import me.study.todo.dto.LoginRespDto;
import me.study.todo.dto.SignupReqDto;
import me.study.todo.dto.SignupRespDto;
import me.study.todo.dto.UpdateUserReqDto;
import me.study.todo.service.AuthService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public SignupRespDto signup(@RequestBody SignupReqDto dto) {
        return authService.signup(dto);
    }

    @PostMapping("/login")
    public LoginRespDto login(@RequestBody LoginReqDto dto) {
        return authService.login(dto);
    }

    @DeleteMapping("/withdraw/{userId}")
    public ResponseEntity<String> withdraw(@PathVariable Long userId) {
        authService.deleteUser(userId);
        return ResponseEntity.ok("회원탈퇴 성공");
    }

    @PutMapping("/user/{userId}")
    public LoginRespDto updateUser(@PathVariable Long userId, @RequestBody UpdateUserReqDto dto) {
        return authService.updateUser(userId, dto);
    }
}