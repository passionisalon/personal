package hello.hellospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value="name", required = true)String name){
        this.thisClassInfo();
        logger.info("helloString(name : {}) invoked.",name);
        String result = "hello "+name;
        logger.info("result : {",result);
        return result;
    }   // end helloString

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value="name",required = true)String name){
        this.thisClassInfo();
        logger.info("helloApi(name : {}) invoked.",name);

        Hello hello = new Hello();
        hello.setName(name);
        logger.info("Hello : {}",hello);
        return hello;

    }   // end helloApi

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }   // end static Hello Class



}   // end class
