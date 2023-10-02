package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // fields
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;

    // constructor
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    // methods

    private void thisClassInfo(){
        System.out.println();
        logger.info("thisClass : {}",this.getClass().getName());
        System.out.println();
    }   // end thisClassInfo




}   // end class
