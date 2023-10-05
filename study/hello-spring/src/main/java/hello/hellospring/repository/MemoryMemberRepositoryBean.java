package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class MemoryMemberRepositoryBean implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    private static final Logger logger = LoggerFactory.getLogger(MemoryMemberRepositoryBean.class);
    private void thisClassInfo(){
        System.out.println();
        logger.info("thisClass : {}",this.getClass().getName());
        System.out.println();
    }   // end thisClassInfo

    @Override
    public Member save(Member member) {
        this.thisClassInfo();
        logger.info("save(member : {}) invoked.",member);

        member.setId(++MemoryMemberRepositoryBean.sequence);
        MemoryMemberRepositoryBean.store.put(member.getId(),member);

        logger.info("member : {}",member);
        logger.info("MemoryMemberRepository.store : {}", MemoryMemberRepositoryBean.store);
        return member;


    }   // end save

    @Override
    public Optional<Member> findById(Long id) {
        this.thisClassInfo();
        logger.info("findById(id : {}) invoked.",id);
        Optional<Member> result = Optional.ofNullable(MemoryMemberRepositoryBean.store.get(id));
        logger.info("result : {}",result);

        return result;
    }   // end findById

    @Override
    public Optional<Member> findByName(String name) {
        this.thisClassInfo();
        logger.info("findByName(name : {}) invoked.",name);
        Optional<Member> result =
                MemoryMemberRepositoryBean.store
                        .values()
                        .stream()
                        .filter(member -> member.getName().equals(name))
                        .findAny();
        logger.info("result : {}",result);
        return result;
    }   // end findByName

    @Override
    public List<Member> findAll() {
        this.thisClassInfo();
        logger.info("findAll() invoked.");

        List<Member> result =
                new ArrayList<>(MemoryMemberRepositoryBean.store.values());
        logger.info("result : {}",result);

        return result;
    }   // end findAll

    public void clearStore(){
        this.thisClassInfo();
        logger.info("clearStore() invoked.");
        MemoryMemberRepositoryBean.store.clear();
    }
}   // end class
