package hello.crudpractice.service;

import hello.crudpractice.domain.Gender;
import hello.crudpractice.domain.Member;
import hello.crudpractice.dto.*;
import hello.crudpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 생성
    public MemberSaveResponseDto createMember(MemberSaveRequestDto requestDto) {
        Member member = Member.builder()
                .email(requestDto.getEmail())
                .name(requestDto.getName())
                .age(requestDto.getAge())
                .gender(requestDto.getGender() == 0 ? Gender.M : Gender.F)
                .build();

        memberRepository.save(member);

        return MemberSaveResponseDto.builder()
                .id(member.getId())
                .build();
    }

    // 조회
    public MemberReadResponseDto readMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 Id가 없습니다.")
        );

        return MemberReadResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .age(member.getAge())
                .gender(member.getGender() == Gender.M ? 0 : 1)
                .build();
    }

    // 수정
    @Transactional
    public MemberUpdateResponseDto updateMember(Long id, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 Id가 없습니다.")
        );

        member.updateMember(requestDto);

        return MemberUpdateResponseDto.builder()
                .id(member.getId())
                .build();
    }

    // 삭제
    public MemberDeleteResponseDto deleteMember(Long id) {
        memberRepository.deleteById(id);

        return MemberDeleteResponseDto.builder()
                .id(id)
                .build();
    }

    // 추천
    @Transactional
    public List<MemberRecommendResponseDto> recommend(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 Id가 없습니다.")
        );

        List<Member> result = memberRepository.findAllByAgeEqualsAndGenderNot(member.getAge(), member.getGender());
        List<MemberRecommendResponseDto> recommendList = new ArrayList<>();

        for (Member recommendMember : result) {
            recommendList.add(MemberRecommendResponseDto.builder()
                    .email(recommendMember.getEmail())
                    .name(recommendMember.getName())
                    .age(recommendMember.getAge())
                    .gender(recommendMember.getGender() == Gender.M ? 0 : 1)
                    .build());
        }
        return recommendList;
    }
}
