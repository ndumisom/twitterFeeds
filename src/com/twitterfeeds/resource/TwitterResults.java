package com.twitterfeeds.resource;

import com.twitterfeeds.config.properties.ConfigVariables;
import com.twitterfeeds.service.TweetServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwitterResults {

    private static final File USERFILE = new File(ConfigVariables.USERFILENAMELOCATION);
    private static final File FILETWEETS = new File(ConfigVariables.TWEETSFILENAMELOCATION);

    public static void main(String[] args) {
        try {
            TweetServiceImpl.displayTwitterFeeds(USERFILE, FILETWEETS);
        } catch (IOException ex) {
            Logger.getLogger(TwitterResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
