package br.com.cesar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class.getName());

    @GetMapping("/test")
    public String testlog(){
        logger.debug("This is an DEBUG Log");
        logger.info("This is an INFO Log");
        logger.warn("This is an WAR Log");
        logger.error("This is an ERROR Log");
        return "Logs generate successfully!";

    }
}
