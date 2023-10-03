//package hello.hellospring;
//
//import hello.hellospring.repository.MemoryMemberRepositoryBean;
//import hello.hellospring.service.MemberServiceBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//
//    @Bean
//    public MemberServiceBean memberService(){
//        return new MemberServiceBean(this.memberRepositoryBean());
//    }
//
//    @Bean
//    public MemoryMemberRepositoryBean memberRepositoryBean(){
//        return new MemoryMemberRepositoryBean();
//    }
//
//}   // end class
