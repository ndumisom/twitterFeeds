package com.twitterfeeds.service;

import com.twitterfeeds.config.properties.ConfigVariables;
import com.twitterfeeds.exceptions.CharacterLengthException;
import com.twitterfeeds.model.Tweets;
import com.twitterfeeds.model.Users;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TweetServiceImpl extends TweetService {
//   This method display twitter feeds
    public static void displayTwitterFeeds(File userFile, File tweetsFile) throws IOException {
        TweetServiceImpl tweetServiceImpl = new TweetServiceImpl();
        List<Users> listOfTwitterUsers = tweetServiceImpl.getListOfTwitterUsers(userFile);
        List<Tweets> listOfTweets = tweetServiceImpl.getListOfTweets(tweetsFile);
//  Call method to display formatted twitterfeed result
        tweetServiceImpl.processDisplayResult(listOfTwitterUsers, listOfTweets);
    }
//This method format data to be displayed on console
    private void processDisplayResult(List<Users> listOfTwitterUsers, List<Tweets> listOfTweets) {
//Loop though list of both Users and Tweets objects to find relationship
        for (int i = 0; i < listOfTwitterUsers.size(); i++) {
// print username
            System.out.println(listOfTwitterUsers.get(i).getUsername());
//Check if the user object has an tweets 
            for (Tweets userTweet : listOfTweets) {
                if (!listOfTwitterUsers.get(i).equals(listOfTwitterUsers.get(listOfTwitterUsers.size() - 1))) {
                    if (userTweet.getUsers().getUsername().equals(listOfTwitterUsers.get(i).getUsername())) {
                        String replaceString = userTweet.getTweetFeed().replaceAll(">", ":");
                        String removeUserName = replaceString.replaceAll(listOfTwitterUsers.get(i).getUsername(), " ");
                        System.out.println("\t" + "@" + listOfTwitterUsers.get(i).getUsername() + removeUserName);
                    }
                } else {
                    String replaceString = userTweet.getTweetFeed().replaceAll(">", ":");
                    String removeUserName = replaceString;
                    System.out.println("\t" + "@" + removeUserName);
                }

            }
        }
    }

//Get the list of all User objects
    @Override
    public List<Users> getListOfTwitterUsers(File userFile) throws IOException {
        String readEachTweeterUserLine;
        List<String> listOfTwitterUsers = new ArrayList<>();
        Set<String> namesForTwitterFollowers = new TreeSet<>();
        Set<Users> users = new TreeSet<>();
        Users user = new Users();
        BufferedReader readUserFile = new BufferedReader(new FileReader(userFile));
        while ((readEachTweeterUserLine = readUserFile.readLine()) != null) {
//           Split the String so you get both followers and followed users
            String[] splitListOfTwitterUsers = readEachTweeterUserLine.split("follows");
            for (int i = 0; i < splitListOfTwitterUsers.length; i++) {
                String[] tweeterUsers = splitListOfTwitterUsers[i].trim().split(",");
                for (int j = 0; j < tweeterUsers.length; j++) {
                    namesForTwitterFollowers.add(tweeterUsers[j].trim());
                }
            }
        }
        for (String follower : namesForTwitterFollowers) {
            if (!follower.equals("")) {
                listOfTwitterUsers.add(follower);
            }
        }
        user.setFollowers(listOfTwitterUsers);
        return user.getFollowers();
    }
// Get list of all tweets objects
    @Override
    public List<Tweets> getListOfTweets(File tweetsFile) throws IOException, FileNotFoundException {
        String readEachTweetLine;
        List<String> listOfTweets = new ArrayList<>();
        Tweets tweet = new Tweets();
        BufferedReader readTweets = new BufferedReader(new FileReader(tweetsFile));
        while ((readEachTweetLine = readTweets.readLine()) != null) {
            if (!readEachTweetLine.equals("")) {
                if (readEachTweetLine.length() <= ConfigVariables.CHARACTERLENGTH) {
                    listOfTweets.add(readEachTweetLine);
                } else {
                    try {
                        throw new CharacterLengthException(ConfigVariables.CHARACTERLENGTHWARNING);
                    } catch (CharacterLengthException ex) {
                        Logger.getLogger(TweetServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        tweet.setTweets(listOfTweets);
        return tweet.getTweets();
    }
}
