/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.gyza.eap.domain;

import java.io.Serializable;

/**
 *
 * @author nikolakg@yahoo.gr   
 */
public class Account implements Serializable {
    private String description;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Username: [").append(this.username);
        buffer.append("] Description: [").append(this.description).append("]S;");
        return buffer.toString();
    }
}
