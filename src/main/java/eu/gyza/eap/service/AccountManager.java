/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.gyza.eap.service;

import eu.gyza.eap.domain.Account;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nikolakg@yahoo.gr
 */
public class  AccountManager implements Serializable{
    
    private List<Account> accounts;
    
    public List<Account> getAccounts(){
         return accounts;
    }
    
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
