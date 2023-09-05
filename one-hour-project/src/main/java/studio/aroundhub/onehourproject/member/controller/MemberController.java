package studio.aroundhub.onehourproject.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import studio.aroundhub.onehourproject.member.controller.dto.JoinRequest;
import studio.aroundhub.onehourproject.member.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

//    Controller -> Service -> Repository

    private final MemberService memberService;

    // 자원을 넣어주는 역할
    @GetMapping("/hello")
    public String getHello(){
        return "Hello Around Hub Studio!";
    }   // end hello

    // 자원을 가져오는 역할
    @PutMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest){
        String id = joinRequest.getId();
        String name = joinRequest.getName();
        String phoneNumber = joinRequest.getPhoneNumber();

//        String result = memberSerivce.join(id,name,phoneNumber);

        String result = memberService.join(joinRequest);
        System.out.printf("result : %s\n",result);

        if(result.equalsIgnoreCase("success")){
            return "success";
        }else{
            return "fail";
        }   // end if - else

    }   // end join
//  API란
//    Application Programming Interface의 줄임말
//    응용 프로그램에서 사용 할 수 있도록 다른 응용 프로그램을 제어할 수 있게 만든 인터페이스를 뜻함
//    API를 사용하면 내부 구현 로직을 알지 못해도 정의되어 있는 기능을 쉽게 사용할 수 있음
//    여기서 인터페이스란 어떤 장치간의 정보를 교환하기 위한 수단이나 방법을 의미함
//    대표적인 인터페이스로는 마우스, 키보드, 터치패드등이 있음

//   REST란
//    REST는 Representational State Transfer의 줄임말
//    자원의 이름으로 구분하여 해당 자원의 상태를 교환하는 것을 의마한다.
//    REST는 서버와 클라이언트의 통신 방식 중 하나임
//    HTTP URI(Uniform Resource Identifier)를 통해 자원을 명시하고 HTTP Method를 통해 자원을 교환하는 것

//   % HTTP Method : Create , Read , Upadte , Delete

//   REST특징
//     Server-Client구조
//      자원이 있는 쪽이 Server, 요청하는 쪽이 Client
//      클라이언트와 서버가 독립적으로 분리되어 있어야 함
//     Statelestt
//      요청 간에 클라이언트 정보가 서버에 저장되지 않음
//      서버는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
//     Cacheable
//      HTTP 프로토콜을 그대로 사용하기 때문에 HTTP의 특징인 캐싱 기능을 적용
//      대량의 요청을 효율적으로 처리하기 위해 캐시를 사용

    // 자원에 대한 조작은 HTTP Method(CRUD)를 통해 표현해야함

//    Mapping의 종류
//    @GetMapping
//    @PutMapping // put은 많이 사용하지 않는다.
//    @PostMapping
//    @DeleteMapping

}   // end class
