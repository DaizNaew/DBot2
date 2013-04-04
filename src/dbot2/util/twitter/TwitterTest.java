/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbot2.util.twitter;

/**
 *
 * @author Daiz
 */
import java.util.List;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {
	private static final String ACCESS_TOKEN = "858476562-nsowsV72koK9pEU6vN27RJZTPdD6LvrHspzSTqH2";
	private static final String ACCESS_TOKEN_SECRET = "OtRipY2rMnOLwKgImNTaIBvQYNKHCNnGZRT7UGxwl4";
	private static final String CONSUMER_KEY = "9BVGCahkpjOH7OcTnOfpCg";
	private static final String CONSUMER_SECRET = "UWlwEbu1wVEW9sHtYBjoExSNJLsjkenB7cLWCZsGDc";

    public static void main(String[] args) throws Exception {
    	ConfigurationBuilder builder = new ConfigurationBuilder();
    	builder.setOAuthAccessToken(ACCESS_TOKEN);
    	builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
    	builder.setOAuthConsumerKey(CONSUMER_KEY);
    	builder.setOAuthConsumerSecret(CONSUMER_SECRET);
        OAuthAuthorization auth = new OAuthAuthorization(builder.build());
        Twitter twitter = new TwitterFactory().getInstance(auth);
        String[] srch = new String[] {"VeniceBux"};
              ResponseList<User> users = twitter.lookupUsers(srch);
              for (User user : users) {
                System.out.println("Friend's Name " + user.getName()); // this print my friends name
                    if (user.getStatus() != null) 
                    {
                    System.out.println("Friend timeline");
                    List<Status> statusess = twitter.getUserTimeline(user.getName());
                    for (Status status3 : statusess) 
                     {
                            System.out.println(status3.getText());
                     }
                    }
              }
    }
}

