package com.twitterfeeds.service;

import com.twitterfeeds.model.Tweet;
import com.twitterfeeds.model.User;
import java.io.File;
import java.io.IOException;
import java.util.List;
public abstract class TweetService {

    public List<Tweet> getListOfTweets(File tweetsFile) throws IOException {
        
        List<Tweet> listOfTweets = null;
        return listOfTweets;
    }

    public List<User> getListOfTwitterUsers(File userFile) throws IOException {
        List<User> listOfTwiterUsers = null;
        return listOfTwiterUsers;
    }

    public static void displayTwitterFeeds(File userFile, File tweetsFile) throws IOException {
    }
}
