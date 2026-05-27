package me.study.todo.service;

import me.study.todo.domain.Dday;
import me.study.todo.domain.User;
import me.study.todo.dto.DdayDeleteRespDto;
import me.study.todo.dto.DdayListRespDto;
import me.study.todo.dto.DdayReqDto;
import me.study.todo.dto.DdayRespDto;
import me.study.todo.repository.DdayRepository;
import me.study.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DdayService {

    private final DdayRepository ddayRepository;
    private final UserRepository userRepository;

    public DdayService(DdayRepository ddayRepository, UserRepository userRepository) {
        this.ddayRepository = ddayRepository;
        this.userRepository = userRepository;
    }

    public DdayListRespDto getDdays(Long userId) {
        List<Dday> ddayList = ddayRepository.findByUser_UserId(userId);

        List<DdayRespDto> respList = new ArrayList<>();

        for (Dday dday : ddayList) {
            respList.add(new DdayRespDto(
                    dday.getDdayId(),
                    dday.getTitle(),
                    dday.getTargetDate().toString(),
                    "D-day 조회 성공"
            ));
        }

        return new DdayListRespDto(userId, respList);
    }

    public DdayRespDto addDday(DdayReqDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다."));

        Dday dday = new Dday();
        dday.setUser(user);
        dday.setTitle(dto.getTitle());
        dday.setTargetDate(LocalDate.parse(dto.getTargetDate()));

        Dday savedDday = ddayRepository.save(dday);

        return new DdayRespDto(
                savedDday.getDdayId(),
                savedDday.getTitle(),
                savedDday.getTargetDate().toString(),
                "D-day 추가 성공"
        );
    }

    public DdayRespDto updateDday(Long ddayId, DdayReqDto dto) {
        Dday dday = ddayRepository.findById(ddayId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 D-day입니다."));

        if (dto.getTitle() != null) {
            dday.setTitle(dto.getTitle());
        }

        if (dto.getTargetDate() != null) {
            dday.setTargetDate(LocalDate.parse(dto.getTargetDate()));
        }

        Dday savedDday = ddayRepository.save(dday);

        return new DdayRespDto(
                savedDday.getDdayId(),
                savedDday.getTitle(),
                savedDday.getTargetDate().toString(),
                "D-day 수정 성공"
        );
    }

    public DdayDeleteRespDto deleteDday(Long ddayId) {
        Dday dday = ddayRepository.findById(ddayId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 D-day입니다."));

        ddayRepository.delete(dday);

        return new DdayDeleteRespDto(ddayId, "D-day 삭제 성공");
    }
}