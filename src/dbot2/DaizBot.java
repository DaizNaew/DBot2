
package dbot2;

import dbot2.Listeners.CheckIRC;
import dbot2.Listeners.Cores.Help;
import dbot2.Listeners.Greeting;
import dbot2.Listeners.Messages;
import dbot2.Listeners.SeenIRC;
import dbot2.Listeners.TwitterFeed;
import dbot2.util.crons.TimedTweet;
import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
/**
 *
 * @author Daiz
 */
public class DaizBot {
    
        
    public static PircBotX bot = new PircBotX(); 
    
    public static final String BOT_PASSWORD = "dbotistrueforceofbux";
    public static final String BOT_NAME = "DBot";
    public static final String BOT_USER_NAME = "DBot";    
    public static final String BOT_FINGER = "You ought to be arrested for fingering a bot";
    public static final String CHANNELS_MAIN = "#Buxftb";
    public static final String NETWORK_NAME = "irc.rizon.net";
    public static final String BOT_VERSION = "a2.0";
    public static final String LINE_STRING = "---------------------------------------------------";
    
    private static String[] channels = { CHANNELS_MAIN, "#Ircbottest" };
    
    public static Channel getMainChannel()
    {
        return bot.getChannel(CHANNELS_MAIN);
    }
    public static PircBotX getBot()
    {
        return bot;
    }
    
        public static Channel[] getChannels()
    {
        Channel[] returnValue = new Channel[channels.length];
        
        for (int i = 0; i < returnValue.length; i++){
            returnValue[i] = bot.getChannel(channels[i]);
        }
        
        return returnValue;
    }
        
        private static boolean activated;
    
        public static void main(String[] args) throws Exception {
            
            bot.setName(BOT_NAME);
            bot.setVerbose(true);
            bot.setMessageDelay(500L);
            bot.setLogin(BOT_USER_NAME);
            bot.setVersion(BOT_VERSION);
            bot.setFinger(BOT_FINGER);
            
            
            bot.connect(NETWORK_NAME);
            bot.identify(BOT_PASSWORD);
            
            bot.getListenerManager().addListener(new Messages());
            bot.getListenerManager().addListener(new Help());
            bot.getListenerManager().addListener(new CheckIRC());
            bot.getListenerManager().addListener(new SeenIRC());
            bot.getListenerManager().addListener(new TwitterFeed());
            bot.getListenerManager().addListener(new Greeting());
            
            for (String channel : channels){
                bot.joinChannel(channel);
            }
            
        }
        
        public static void disconnect()
    {
        try {
            bot.disconnect();
            System.exit(0);
        } catch (Exception e)
        {
        }
    }
            public static void setActivated(boolean activated)
    {
        DaizBot.activated = activated;
        TimedTweet.initialize();
    }
    
}
