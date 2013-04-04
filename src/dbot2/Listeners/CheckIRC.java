package dbot2.Listeners;

import dbot2.Listeners.Cores.BotCommand;
import dbot2.util.BuxAPI;
import dbot2.util.enums.AccessLevel;
import dbot2.util.enums.ColorFormat;
import dbot2.util.messages.ErrorMessages;
import dbot2.util.messages.Messages;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

public class CheckIRC extends BotCommand
{
    public CheckIRC()
    {
        getAliases().add("!check");
        getAliases().add("!player");
        
        setMinAccessLevel(AccessLevel.NORMAL);
        
        setArgumentsString("<player name>");
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void onMessage(MessageEvent<PircBotX> event) throws Exception
    {
        if (performGenericChecks(event.getChannel(), event.getUser(), event.getMessage().split(" ")))
        {
            if (getArgs().length == 2)
            {
                String playerName = getArgs()[1];
                String balance = BuxAPI.getPlayerMoney(playerName);
            	String town = BuxAPI.getPlayerTown(playerName);
            	String vacation = BuxAPI.getPlayerVacation(playerName);
            	String seen = BuxAPI.getPlayerSeen(playerName);
            	String stats = "";
                if (stats.contains(",")) {
                    stats = stats.substring(0, stats.length() - 4);
                }
                
                if (balance != "playerDoesntExist")
                {
                    Messages.sendNotice(ColorFormat.NORMAL, getUser(), 
                    "Player &b" + playerName + "&n has the balance of &4&b" + balance + " Bux&n. " + 
                    "Last Seen: &4&b" + seen + 
                    "&n. Town: &4&b" + town + 
                    "&n. On Vacation: &4&b" + vacation);
                } else {
                    ErrorMessages.notFoundPlayer(getChannel(), getUser(), playerName);
                };
            }
        }
    }
}
