/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.gyza.eap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nikolakg
 */
@Controller
public class HelloController {
    
    public HelloController() {
       
    }
    
    @RequestMapping(value = "/index2.htm")
        public ModelAndView indexPage() {
        return new ModelAndView("index");
    }
    
    
    @RequestMapping("/hello.htm")
    public ModelAndView helloWorld() {
 
        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("hello", "message", message);
    } 
 
    
}
