
package dbot2.Listeners;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
/**
 *
 * @author Daiz
 */
public class Greeting extends ListenerAdapter {
    
    public void onJoinEvent(JoinEvent event) throws Exception {
        event.respond("&2Greetings: &9"+event.getUser().getNick());
    }
}