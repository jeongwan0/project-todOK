package me.study.todo.controller;

import me.study.todo.dto.DdayDeleteRespDto;
import me.study.todo.dto.DdayListRespDto;
import me.study.todo.dto.DdayReqDto;
import me.study.todo.dto.DdayRespDto;
import me.study.todo.service.DdayService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ddays")
public class DdayController {

    private final DdayService ddayService;

    public DdayController(DdayService ddayService) {
        this.ddayService = ddayService;
    }

    @GetMapping
    public DdayListRespDto getDdays(@RequestParam Long userId) {
        return ddayService.getDdays(userId);
    }

    @PostMapping
    public DdayRespDto addDday(@RequestBody DdayReqDto dto) {
        return ddayService.addDday(dto);
    }

    @PutMapping("/{ddayId}")
    public DdayRespDto updateDday(
            @PathVariable Long ddayId,
            @RequestBody DdayReqDto dto
    ) {
        return ddayService.updateDday(ddayId, dto);
    }

    @DeleteMapping("/{ddayId}")
    public DdayDeleteRespDto deleteDday(@PathVariable Long ddayId) {
        return ddayService.deleteDday(ddayId);
    }
}