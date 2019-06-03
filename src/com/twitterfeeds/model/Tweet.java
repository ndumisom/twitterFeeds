package com.twitterfeeds.model;

import java.util.ArrayList;
import java.util.List;
public class Tweet {
    private Integer tweetId;
    private String tweetFeed;
    private User users;
    private List<Tweet> tweets;

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetFeed() {
        return tweetFeed;
    }

    public void setTweetFeed(String tweetFeed) {
        this.tweetFeed = tweetFeed;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
    
    public List<Tweet> getTweets() {
       return tweets;
    }
    
     public void setTweets(List<String> listOfTweets) {
        List<Tweet> listTweets = new ArrayList<>();
        for (int i = 0; i < listOfTweets.size(); i++) {
            Tweet tweet = new Tweet();
            tweet.setTweetId(i + 1);
            tweet.setTweetFeed(listOfTweets.get(i));
            User user = new User();
            String[] userNameList = listOfTweets.get(i).split(">");
            user.setUserId(tweet.getTweetId());
            user.setUsername(userNameList[0]);
            tweet.setUsers(user);
            listTweets.add(tweet);
        }
        this.tweets = listTweets;
    }   
 }
