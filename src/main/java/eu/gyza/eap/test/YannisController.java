/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.gyza.eap.test;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nikolakg@yahoo.gr
 */
@Controller
public class YannisController {
    
        private final Facebook facebook;
        
        @Inject
	public YannisController(Facebook facebook) {
		this.facebook = facebook;
	}
    
        @RequestMapping(value="/test/friends", method=RequestMethod.GET)
	public String showFeed(Model model) {
		model.addAttribute("friends", facebook.friendOperations().getFriendProfiles());
		return "facebook/friends";
	}
	
        
	@RequestMapping("/yannis.htm")
	public String simple() {
		return "hello";
	}
        
        @RequestMapping(value = "/helloWorld.htm", method = RequestMethod.GET )
        public ModelAndView hello(){
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("message", "Hello,v Spring-MVC World");
            return new ModelAndView("hello", model);
    }
}
