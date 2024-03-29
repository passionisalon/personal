package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberServiceBean {

    // filed
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceBean(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // methods
    /**
     * 회원 가입
     */
    public Long join(Member member){
        long start = System.currentTimeMillis();

        try{
            System.out.printf("join(Member : %s) invoked.\n",member);
            // 중복 회원 검증
            this.validateDuplicateMember(member);

            this.memberRepository.save(member);
            return member.getId();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.printf("timeMs of join's method : %s\n",timeMs);
        }


        // 같은 이름이 있는 중복회원이 있으면 안된다.
        // 원래 코드
//        Optional<Member> result = this.memberRepository.findByName(member.getName());
//        System.out.printf("result : %s",result.get());
//
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });


    }   // end join

    private void validateDuplicateMember(Member member) {
        this.memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }   // end validateDuplicateMember

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        long start = System.currentTimeMillis();
        try{
            System.out.printf("findMembers() invoked.\n");

            List<Member> result = this.memberRepository.findAll();
            System.out.printf("result : %s\n",result);

            return result;
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.printf("timeMs of findMembers'method : %s\n",timeMs);
        }

    }   // end findMembers

    public Optional<Member> findOne(Long memberId){
        return this.memberRepository.findById(memberId);
    }   // end findOne

}   // end class
