/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.gyza.eap.controller;
import eu.gyza.eap.service.AccountManager;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author nikolakg@yahoo.gr
 */
public class UserController implements Controller {
    protected final Log logger = LogFactory.getLog(getClass());

    private AccountManager accountManager;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new java.util.Date()).toString();
        logger.info("returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("accounts", this.accountManager.getAccounts());
        return new ModelAndView("hello", "model", myModel);
    }


    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    } 
}
