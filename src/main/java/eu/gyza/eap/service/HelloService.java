/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.gyza.eap.service;

import java.io.Serializable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author nikolakg
 */
public class HelloService implements Serializable{

    public HelloService() {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("deslos@yahoo.com", null, null));	
    }
    
    
    
    public static String sayHello(String name) {
        return "Hello " + name + "!";
    }
    
    /**
     * Programmatically signs in the user with the given the user ID.
     * @param userId
     */
    public static void signin() {
            
    }
	
}
