package hello.hellospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller


public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private void thisClassInfo(){
        System.out.println();
        logger.info("thisClass : {}",this.getClass().getName());
        System.out.println();
    }

    @GetMapping("hello")
    public String hello(Model model) {
        this.thisClassInfo();
        logger.info("hello(Model : {}) invoked.",model);

        model.addAttribute("data","spring!!!");
        return "hello";
    }   // end hello

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        this.thisClassInfo();
        logger.info("helloMvc(name : {}, model : {}) invoked.",name,model);
        model.addAttribute("name",name);

        return "hello-template";
    }   // end helloMvc

}   // end class
