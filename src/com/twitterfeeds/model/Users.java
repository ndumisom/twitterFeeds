/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitterfeeds.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josch
 */
public class Users {
    private Integer userId;
    private String username;
    List<Users> followers;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public List<Users> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> listOfTwitterUsers) {
        List<Users> twitterUsers = new ArrayList<>();
        for (int i = 0; i < listOfTwitterUsers.size(); i++) {
            Users user = new Users();
            user.setUserId(i + 1);
            user.setUsername(listOfTwitterUsers.get(i));
            twitterUsers.add(user);
        }
        followers = twitterUsers;
    }   
}
