/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbot2.Listeners;

import java.util.List;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import twitter4j.*;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Daiz
 */
public class TwitterFeed extends ListenerAdapter {
        private static final String ACCESS_TOKEN = "858476562-nsowsV72koK9pEU6vN27RJZTPdD6LvrHspzSTqH2";
	private static final String ACCESS_TOKEN_SECRET = "OtRipY2rMnOLwKgImNTaIBvQYNKHCNnGZRT7UGxwl4";
	private static final String CONSUMER_KEY = "9BVGCahkpjOH7OcTnOfpCg";
	private static final String CONSUMER_SECRET = "UWlwEbu1wVEW9sHtYBjoExSNJLsjkenB7cLWCZsGDc";
        
        @Override
        public void onMessage (MessageEvent event )throws Exception {
        if (event.getMessage().toLowerCase().endsWith(": !news") && event.getUser().getNick().equalsIgnoreCase("Bux") 
                || event.getMessage().equalsIgnoreCase("!news")){            
        
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
                    if (user.getStatus() != null)
                    {
                    List<Status> statuses = twitter.getUserTimeline(user.getName(), new Paging(1,1));
                        for (Status status3 : statuses)
                    
                     {
                             event.getBot().sendMessage(event.getChannel(),"&9@venicebux: "+"&6"+ status3.getText()+" -&9 https://twitter.com/VeniceBux");
                     }
                    }
              }
        }
        }
}