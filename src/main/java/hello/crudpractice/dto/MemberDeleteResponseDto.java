package hello.crudpractice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDeleteResponseDto {
    private Long id;
}