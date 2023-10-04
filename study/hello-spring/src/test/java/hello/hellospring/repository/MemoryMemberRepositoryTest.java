package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

//    MemberRepository memoryMemberRepository = new MemoryMemberRepository();
    MemoryMemberRepositoryBean memoryMemberRepository = new MemoryMemberRepositoryBean();
    private static final Logger logger = LoggerFactory.getLogger(MemoryMemberRepositoryBean.class);

    private void thisClassInfo(){
        System.out.println();
        logger.info("thisClass : {}",this.getClass().getName());
        System.out.println();
    }   // end thisClassInfo

    @AfterEach
    public void afterEach(){
        this.thisClassInfo();
        logger.info("afterEach() invoked.");
        this.memoryMemberRepository.clearStore();
    }   // end afterEach

    @Test
    public void save(){
        this.thisClassInfo();
        logger.info("save() invoked.");

        Member member = new Member();
        member.setName("TestName");

        this.memoryMemberRepository.save(member);

        Member result = this.memoryMemberRepository.findById(member.getId()).get();
        logger.info("result : {}",(result == member));

        // org.junit.jupiter.api.Assertions
//        Assertions.assertEquals(member, result);

        // org.assertj.core.api.Assertions
        assertThat(member).isEqualTo(result);

    }   // end save

    @Test
    public void findByName(){
        this.thisClassInfo();
        logger.info("findByName() invoked.");

        Member member1 = new Member();
        member1.setName("spring1");
        this.memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        this.memoryMemberRepository.save(member2);

        this.thisClassInfo();
        logger.info("findByName() invoked.");
        Optional<Member> result1 = this.memoryMemberRepository.findByName("spring1");
        logger.info("result1 : {}",result1);
        logger.info("result1 isEquals member1 : {}",(member1 == result1.get()));

        Member result2 = this.memoryMemberRepository.findByName("spring1").get();
        logger.info("result2 : {}",result2);

        assertThat(result2).isEqualTo(member1);
    }   // end findByName

    @Test
    public void findAll(){
        this.thisClassInfo();
        logger.info("findAll() invoked.");

        Member member1 = new Member();
        member1.setName("spring1");
        this.memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        this.memoryMemberRepository.save(member2);

        List<Member> result = this.memoryMemberRepository.findAll();
        logger.info("result : {}",result);

        assertThat(result.size()).isEqualTo(2);
    }

}   // enc  lass
