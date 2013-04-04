/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbot2.util.crons;

import dbot2.DaizBot;
import dbot2.util.messages.Messages;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Daiz
 */
public class TimedTweet  {
    public static final long PAYDAY_MINUTES = 60;
    private static boolean initialized = false;
    
    private static final String ACCESS_TOKEN = "858476562-nsowsV72koK9pEU6vN27RJZTPdD6LvrHspzSTqH2";
    private static final String ACCESS_TOKEN_SECRET = "OtRipY2rMnOLwKgImNTaIBvQYNKHCNnGZRT7UGxwl4";
    private static final String CONSUMER_KEY = "9BVGCahkpjOH7OcTnOfpCg";
    private static final String CONSUMER_SECRET = "UWlwEbu1wVEW9sHtYBjoExSNJLsjkenB7cLWCZsGDc";
    
    private static class GivePay
    {
        private static class LoopTask extends TimerTask
        {
            @Override
            public void run()
            {
                try {
                    ConfigurationBuilder builder = new ConfigurationBuilder();
                builder.setOAuthAccessToken(ACCESS_TOKEN);
                builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
                builder.setOAuthConsumerKey(CONSUMER_KEY);
                builder.setOAuthConsumerSecret(CONSUMER_SECRET);
            
            OAuthAuthorization auth = new OAuthAuthorization(builder.build());
                        Twitter twitter = new TwitterFactory().getInstance(auth);
                        String[] srch = new String[] {"VeniceBux"};
                            ResponseList<twitter4j.User> users = twitter.lookupUsers(srch);
                                for (twitter4j.User user : users) {
                                    if (user.getStatus() != null) {
                                        try {
                                            System.out.println("Friend timeline");
                                List<Status> statuses = twitter.getUserTimeline(user.getName(), new Paging(1,1));
                                for (Status status3 : statuses) {
                                    Messages.sendMessage(DaizBot.getMainChannel(),"&9@venicebux: "+"&6"+ status3.getText()+" -&9 https://twitter.com/VeniceBux");
                                        }
                                    }catch (TwitterException ex) {
                                        Logger.getLogger(TimedTweet.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    }
                                }
                } catch (TwitterException ex) {
                    Logger.getLogger(TimedTweet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
        long delay = 1000 * 60 * PAYDAY_MINUTES;
        LoopTask task = new LoopTask();
        Timer timer = new Timer("GivePay");
    
        public void start()
        {
            timer.cancel();
            timer = new Timer("GivePay");
            Date executionDate = new Date(); // no params = now
            timer.scheduleAtFixedRate(task, executionDate, delay);
        }
    }
    
    public static void initialize()
    {
        if (!initialized)
        {
            GivePay gp = new GivePay();
            gp.start();
            initialized = true;
        }
    }
}
