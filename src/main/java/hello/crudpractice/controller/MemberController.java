package hello.crudpractice.controller;

import hello.crudpractice.dto.*;
import hello.crudpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 생성
    @PostMapping("/create")
    public MemberSaveResponseDto createMember(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.createMember(requestDto);
    }

    // 조회
    @GetMapping("/read/{id}")
    public MemberReadResponseDto readMember(@PathVariable Long id) {
        return memberService.readMember(id);
    }

    // 수정
    @PutMapping("/update/{id}")
    public MemberUpdateResponseDto updateMember(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/delete/{id}")
    public MemberDeleteResponseDto deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }

    // 추천
    @GetMapping("/recommend/{id}")
    public List<MemberRecommendResponseDto> recommend(@PathVariable Long id) {
        return memberService.recommend(id);
    }
}
