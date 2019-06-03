package com.twitterfeeds.model;

import java.util.ArrayList;
import java.util.List;
public class User {
    private Integer userId;
    private String username;
    List<User> followers;

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
    
    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> listOfTwitterUsers) {
        List<User> twitterUsers = new ArrayList<>();
        for (int i = 0; i < listOfTwitterUsers.size(); i++) {
            User user = new User();
            user.setUserId(i + 1);
            user.setUsername(listOfTwitterUsers.get(i));
            twitterUsers.add(user);
        }
        followers = twitterUsers;
    }   
}
