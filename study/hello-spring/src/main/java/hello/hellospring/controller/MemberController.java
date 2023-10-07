package hello.hellospring.controller;


import hello.hellospring.domain.Member;
//import hello.hellospring.service.MemberService;
//import hello.hellospring.service.MemberServiceBean;
import hello.hellospring.service.MemberServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    private MemberServiceBean memberService;

    @Autowired
    public MemberController(MemberServiceBean memberService){
        this.memberService = memberService;
        System.out.printf("this.memberService : %s\n",this.memberService.getClass());

    }


    // methods

    private void thisClassInfo(){
        System.out.println();
        logger.info("thisClass : {}",this.getClass().getName());
        System.out.println();
    }   // end thisClassInfo

    @GetMapping("/members/new")
    public String createForm(){
        this.thisClassInfo();
        logger.info("createfrom() invoked.");
        return "members/createMemberForm";
    }   // end createForm

    @PostMapping("/members/new")
    public String create(MemberForm form){
        this.thisClassInfo();
        logger.info("create(MemberForm : {}) invoked.",form);
        Member member = new Member();
        member.setName(form.getName());
        this.memberService.join(member);

        return "redirect:/";
    }   // end create

    @GetMapping("/members")
    public String list(Model model){
        this.thisClassInfo();
        logger.info("list(Model : {}) invoked.",model);

        List<Member> members = this.memberService.findMembers();
        logger.info("members : {}",members);
        model.addAttribute("members",members);


        return "members/memberList";
    }   // end list

}   // end class
