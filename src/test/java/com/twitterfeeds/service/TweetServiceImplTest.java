package test.java.com.twitterfeeds.service;

import com.twitterfeeds.config.properties.ConfigVariables;
import com.twitterfeeds.model.Tweets;
import com.twitterfeeds.model.Users;
import com.twitterfeeds.service.TweetServiceImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TweetServiceImplTest {
    
    public TweetServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListOfTweets method, of class TweetServiceImpl.
     */
    @Test
    public void testGetListOfTweets() throws Exception {
        System.out.println("getListOfTweets");
        File tweetsFile = new File(ConfigVariables.TWEETSFILENAMELOCATION);
        TweetServiceImpl instance = new TweetServiceImpl();
        List<String> listOfTweets = new ArrayList<>();
        
        Tweets tweet1 = new Tweets();
        Tweets tweet2 = new Tweets();
        Tweets tweet3 = new Tweets();
        List<Tweets> twitterUsers = new ArrayList<>();
        
        tweet1.setTweetFeed("Alan> If you have a procedure with 10 parameters, you probably missed some.");
        tweet1.setTweetId(1);
        tweet1.setTweets(listOfTweets);
        Users user1 = new Users();
        user1.setUserId(1);
        user1.setUsername("Alan");
        tweet1.setUsers(user1);
        
        tweet2.setTweetFeed("Ward> There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors.");
        tweet2.setTweetId(1);
        tweet2.setTweets(listOfTweets);
        Users user2 = new Users();
        user1.setUserId(3);
        user1.setUsername("Ward");
        tweet1.setUsers(user2);
        
        
        tweet3.setTweetFeed("Alan> If you have a procedure with 10 parameters, you probably missed some.");
        tweet3.setTweetId(1);
        tweet3.setTweets(listOfTweets);
        Users user3 = new Users();
        user3.setUserId(1);
        user3.setUsername("Alan");
        tweet3.setUsers(user3);
        
        
        twitterUsers.add(tweet1);
        twitterUsers.add(tweet2);
        twitterUsers.add(tweet3);
        List expResult = twitterUsers;
        List result = instance.getListOfTweets(tweetsFile);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getListOfTwiterUsers method, of class TweetServiceImpl.
     */
    @Test
    public void testGetListOfTwiterUsers() throws Exception {
        System.out.println("getListOfTwiterUsers");
        File userFile = new File(ConfigVariables.USERFILENAMELOCATION);
        TweetServiceImpl instance = new TweetServiceImpl();
        Users user1 = new Users();
        Users user2 = new Users();
        Users user3 = new Users();
        List<Users> twitterUsers = new ArrayList<>();
        user1.setUserId(1);
        user1.setUsername("Alan");
        user2.setUserId(2);
        user2.setUsername("Martin");
        user3.setUserId(3);
        user3.setUsername("Ward");
        twitterUsers.add(user1);
        twitterUsers.add(user2);
        twitterUsers.add(user3);
        List expResult = twitterUsers;
        List result = instance.getListOfTwitterUsers(userFile);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of displayTwitterFeeds method, of class TweetServiceImpl.
     */
    @Test
    public void testDisplayTwitterFeeds() throws Exception {
        System.out.println("displayTwitterFeeds");
        File userFile = new File(ConfigVariables.USERFILENAMELOCATION);
        File tweetsFile = new File(ConfigVariables.TWEETSFILENAMELOCATION);
        TweetServiceImpl.displayTwitterFeeds(userFile, tweetsFile);
    }
}
