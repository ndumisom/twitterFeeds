package com.twitterfeeds.model;

import java.util.ArrayList;
import java.util.List;
public class Tweets {
    private Integer tweetId;
    private String tweetFeed;
    private Users users;
    private List<Tweets> tweets;

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public List<Tweets> getTweets() {
       return tweets;
    }
    
     public void setTweets(List<String> listOfTweets) {
        List<Tweets> listTweets = new ArrayList<>();
        for (int i = 0; i < listOfTweets.size(); i++) {
            Tweets tweet = new Tweets();
            tweet.setTweetId(i + 1);
            tweet.setTweetFeed(listOfTweets.get(i));
            Users user = new Users();
            String[] userNameList = listOfTweets.get(i).split(">");
            user.setUserId(tweet.getTweetId());
            user.setUsername(userNameList[0]);
            tweet.setUsers(user);
            listTweets.add(tweet);
        }
        this.tweets = listTweets;
    }   
 }
