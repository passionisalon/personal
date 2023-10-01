package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // fields
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    // methods

    @BeforeEach
    public void beforeEach(){
        this.memberRepository = new MemoryMemberRepository();
        this.memberService = new MemberService(this.memberRepository);
    }

    @AfterEach
    public void afterEach(){
        this.memberRepository.clearStore();
    }
    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = this.memberService.join(member);
        // then
        Member findMember = this.memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }   // end join

    @Test
    public void 중복_회원_예외(){
        System.out.println("중복_회원_예외");
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        this.memberService.join(member1);
        IllegalStateException exceptionResult =
                assertThrows(
                    IllegalStateException.class,
                    ()->this.memberService.join(member2)
                );
        assertThat(exceptionResult.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            this.memberService.join(member1);
//            this.memberService.join(member2);
//            fail();
////            fail("예외가 발생해야합니다.");
//        }catch(IllegalStateException e){
//            e.printStackTrace();
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        // then


    }





    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}