package hello.hellospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // fields
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    // methods

    private void thisClassInfo(){
        System.out.println("");
        logger.info("thisClass is : {}",this.getClass().getName());
        System.out.println("");
    }

    @GetMapping("/")
    public String home(){
        this.thisClassInfo();
        logger.info("home() invoked.");
        return "home";
    }   // end home
}   // end class
