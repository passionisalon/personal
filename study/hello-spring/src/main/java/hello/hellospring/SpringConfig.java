package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    // SpringDataJpaMemberRepository를 만들면 아래의 @Bean public MemberReepository memberRepositoryBean()을 없애도 구동이 된다.

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberServiceBean memberService(){

//        return new MemberServiceBean(this.memberRepositoryBean());
        return new MemberServiceBean(this.memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepositoryBean(){
//        return new MemoryMemberRepositoryBean();
//        return new JdbcMemberRepository(this.dataSource);
//        return new JdbcTemplateMemberRepository(this.dataSource);
//        return new JpaMemberRepository(this.em);
//    }


}   // end class
