package hello.crudpractice.dto;

import hello.crudpractice.domain.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberRecommendResponseDto {
    private String email;
    private String name;
    private int age;
    private int gender;
}
