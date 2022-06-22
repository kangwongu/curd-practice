package hello.crudpractice.repository;

import hello.crudpractice.domain.Gender;
import hello.crudpractice.domain.Member;
import hello.crudpractice.dto.MemberRecommendResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByAgeEqualsAndGenderNot(int age, Gender gender);
}

