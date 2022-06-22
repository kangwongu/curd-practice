package hello.crudpractice.dto;

import hello.crudpractice.domain.Gender;
import lombok.Getter;

@Getter
public class MemberSaveRequestDto {
    private String email;
    private String name;
    private int age;
    private int gender;
}
