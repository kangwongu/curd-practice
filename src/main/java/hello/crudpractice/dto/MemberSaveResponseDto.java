package hello.crudpractice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberSaveResponseDto {
    private Long id;
}
