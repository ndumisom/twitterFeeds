package com.twitterfeeds.service;

import com.twitterfeeds.model.Tweets;
import com.twitterfeeds.model.Users;
import java.io.File;
import java.io.IOException;
import java.util.List;
public abstract class TweetService {

    public List<Tweets> getListOfTweets(File tweetsFile) throws IOException {
        
        List<Tweets> listOfTweets = null;
        return listOfTweets;
    }

    public List<Users> getListOfTwitterUsers(File userFile) throws IOException {
        List<Users> listOfTwiterUsers = null;
        return listOfTwiterUsers;
    }

    public static void displayTwitterFeeds(File userFile, File tweetsFile) throws IOException {
    }
}
