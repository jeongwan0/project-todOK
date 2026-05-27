package me.study.todo.service;

import me.study.todo.domain.User;
import me.study.todo.dto.LoginReqDto;
import me.study.todo.dto.LoginRespDto;
import me.study.todo.dto.SignupReqDto;
import me.study.todo.dto.SignupRespDto;
import me.study.todo.dto.UpdateUserReqDto;
import me.study.todo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignupRespDto signup(SignupReqDto dto) {

        if (userRepository.findByLoginId(dto.getLoginId()).isPresent()) {
            throw new RuntimeException("이미 사용 중인 아이디입니다.");
        }

        User user = new User();
        user.setLoginId(dto.getLoginId());
        user.setPassword(dto.getPassword());
        user.setNickname(dto.getNickname());

        LocalDate today = LocalDate.now();
        LocalDate nextNewYear = LocalDate.of(today.getYear() + 1, 1, 1);
        long ddayNum = ChronoUnit.DAYS.between(today, nextNewYear);

        user.setDdayname("신년");
        user.setDdaydate(nextNewYear.toString().replace("-", ""));
        user.setDdaynum((int) ddayNum);

        User savedUser = userRepository.save(user);

        return new SignupRespDto(
                savedUser.getUserId(),
                savedUser.getLoginId(),
                savedUser.getNickname(),
                "회원가입 성공"
        );
    }

    public LoginRespDto login(LoginReqDto dto) {
        User user = userRepository.findByLoginId(dto.getLoginId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다."));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return new LoginRespDto(
                user.getUserId(),
                user.getLoginId(),
                user.getNickname(),
                user.getPassword(),
                user.getDdayname(),
                user.getDdaydate(),
                user.getDdaynum(),
                "로그인 성공"
        );
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        userRepository.delete(user);
    }

    public LoginRespDto updateUser(Long userId, UpdateUserReqDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        if (dto.getNickname() != null) {
            user.setNickname(dto.getNickname());
        }

        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword());
        }

        if (dto.getDdayname() != null) {
            user.setDdayname(dto.getDdayname());
        }

        if (dto.getDdaydate() != null) {
            user.setDdaydate(dto.getDdaydate());
        }

        if (dto.getDdaynum() != null) {
            user.setDdaynum(dto.getDdaynum());
        }

        User updatedUser = userRepository.save(user);

        return new LoginRespDto(
                updatedUser.getUserId(),
                updatedUser.getLoginId(),
                updatedUser.getNickname(),
                updatedUser.getPassword(),
                updatedUser.getDdayname(),
                updatedUser.getDdaydate(),
                updatedUser.getDdaynum(),
                "회원정보 수정 성공"
        );
    }
}