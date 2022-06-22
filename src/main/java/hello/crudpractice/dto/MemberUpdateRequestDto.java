package hello.crudpractice.dto;

import hello.crudpractice.domain.Gender;
import lombok.Getter;

@Getter
public class MemberUpdateRequestDto {
    private String name;
    private int age;
    private Gender gender;
}
