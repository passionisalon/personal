package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.service.MemberServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    public MemberServiceBean memberService(){
        return new MemberServiceBean(this.memberRepositoryBean());
    }

    @Bean
    public JdbcMemberRepository memberRepositoryBean(){
//        return new MemoryMemberRepositoryBean();
        return new JdbcMemberRepository(this.dataSource);
    }

}   // end class
