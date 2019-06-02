package com.twitterfeeds.config.properties;
public class ConfigVariables {
    
    private ConfigVariables() { }  // Prevents instantiation

    /**
     *In case you want to change configuration ,you make change in one file
     */
    public static final Integer CHARACTERLENGTH = 140;
    public static final String USERFILENAMELOCATION = "files/user.txt";
    public static final String TWEETSFILENAMELOCATION = "files/tweet.txt";
    public static final String CHARACTERLENGTHWARNING = "Line length is over limit of 140 characters";
    
}
