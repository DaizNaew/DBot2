
package dbot2.Listeners.Cores;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */
public class Help extends ListenerAdapter {
    
    private static final String MASTER = "Bux";
    public static final String HELPCOMMANDS = "!help, !npc, !color, !check, !seen, !news";
    
    @Override
    public void onMessage(MessageEvent event) {
        
            if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().endsWith(": !help") || event.getMessage().equalsIgnoreCase("!help")){
                event.getBot().sendMessage(event.getChannel(), "I currently supports the following commands: "+HELPCOMMANDS+".");}
            }
    }
