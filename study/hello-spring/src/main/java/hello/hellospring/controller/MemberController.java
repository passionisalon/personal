package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
//import hello.hellospring.service.MemberServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // fields
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

//    어노테이션 사용시 @Service
//    private final MemberService memberService;



    //필드 주입
//    @Autowired
//    private MemberService memberService;

    // constructor
    // 생성자 주입
    //    SpringConfig Bean 사용시
//    private final MemberServiceBean memberService;
//    @Autowired
//    public MemberController(MemberServiceBean memberService) {
//        this.memberService = memberService;
//    }

    // setter 주입
//    private MemberService memberService;
//
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

//    요새는 생성자로 만드는 것이 좋다. 객체가 생성되면서 하나씩 연결이 되기 떄문이다.

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;

    }


    // methods

    private void thisClassInfo(){
        System.out.println();
        logger.info("thisClass : {}",this.getClass().getName());
        System.out.println();
    }   // end thisClassInfo




}   // end class
