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

    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Autowired


    @Bean
    public MemberServiceBean memberService(){
        return new MemberServiceBean(this.memberRepositoryBean());
    }

    @Bean
    public MemberRepository memberRepositoryBean(){
//        return new MemoryMemberRepositoryBean();
//        return new JdbcMemberRepository(this.dataSource);
//        return new JdbcTemplateMemberRepository(this.dataSource);
        return new JpaMemberRepository(this.em);
    }


}   // end class
