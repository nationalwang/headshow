package com.headshow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linlangleo
 * @desc test
 * @date 2018-08-10 18:12
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){

        System.out.println(System.getProperty("user.dir"));
        try{
            double i = 1/0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "321123";
    }
}
