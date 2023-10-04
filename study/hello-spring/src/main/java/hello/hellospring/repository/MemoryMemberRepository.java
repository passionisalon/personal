//package hello.hellospring.repository;
//
//import hello.hellospring.controller.HelloController;
//import hello.hellospring.domain.Member;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class MemoryMemberRepository implements MemberRepository {
//
//    private static Map<Long,Member> store = new HashMap<>();
//
//    private static long sequence = 0L;
//
//    private static final Logger logger = LoggerFactory.getLogger(MemoryMemberRepository.class);
//    private void thisClassInfo(){
//        System.out.println();
//        logger.info("thisClass : {}",this.getClass().getName());
//        System.out.println();
//    }   // end thisClassInfo
//
//    @Override
//    public Member save(Member member) {
//        this.thisClassInfo();
//        logger.info("save(member : {}) invoked.",member);
//
//        member.setId(++MemoryMemberRepository.sequence);
//        MemoryMemberRepository.store.put(member.getId(),member);
//
//        logger.info("member : {}",member);
//        logger.info("MemoryMemberRepository.store : {}",MemoryMemberRepository.store);
//        return member;
//
//
//    }   // end save
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        this.thisClassInfo();
//        logger.info("findById(id : {}) invoked.",id);
//        Optional<Member> result = Optional.ofNullable(MemoryMemberRepository.store.get(id));
//        logger.info("result : {}",result);
//
//        return result;
//    }   // end findById
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        this.thisClassInfo();
//        logger.info("findByName(name : {}) invoked.",name);
//        Optional<Member> result =
//                MemoryMemberRepository.store
//                        .values()
//                        .stream()
//                        .filter(member -> member.getName().equals(name))
//                        .findAny();
//        logger.info("result : {}",result);
//        return result;
//    }   // end findByName
//
//    @Override
//    public List<Member> findAll() {
//        this.thisClassInfo();
//        logger.info("findAll() invoked.");
//
//        List<Member> result =
//                new ArrayList<>(MemoryMemberRepository.store.values());
//        logger.info("result : {}",result);
//
//        return result;
//    }   // end findAll
//
//    public void clearStore(){
//        this.thisClassInfo();
//        logger.info("clearStore() invoked.");
//        MemoryMemberRepository.store.clear();
//    }
//}   // end class
