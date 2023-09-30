package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 회원이 회원소에 저장이됨 save
    Member save(Member member);
    // 회원의 아이디를 통해서 찾아오는 기능
    Optional<Member> findById(Long id);
    // 회원의 이름을 통해서 찾아오는 기능
    Optional<Member> findByName(String name);
    // 저장소에 있는 회원 전체를 반환하는 기능
    List<Member> findAll();

}   // end interface
