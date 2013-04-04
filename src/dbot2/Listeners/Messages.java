package dbot2.Listeners;

import dbot2.DaizBot;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Daiz
 */


public class Messages extends ListenerAdapter {
    
    public static final String MASTER = "bux";
    public static final String COLOUR = "&00&11&22&33&44&55&66&77&88&99&aa&bb&cc&dd&ee&ff &ll&r &mm&r &nn&r &oo&r";
    private static String[] colors = { "!color", "!colour", "!colours", "!colors"};
    public static final String COMMAND ="!npc";
    public static final String NPCLIST = "Ethel, Ted, Alchemy, Banking, Combat, Construction, Control, Demolition, Gaming, Gathering, Husbandry, Mechanics, Mysticism, Omerta, Shopkeeping, Storage, Trading, Travel, Zoning, Teaching";
    
    @Override
    public void onMessage(MessageEvent event) {
                
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().endsWith(": "+COMMAND) || event.getMessage().equalsIgnoreCase(COMMAND)) {
        event.getBot().sendMessage(event.getChannel(), "This command will give you the cords of npcs, write !npc <name> for usage.");
        event.getBot().sendMessage(event.getChannel(), "You can use !npc list to get the names of the npcs"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" ethel") || event.getMessage().equalsIgnoreCase(COMMAND+" ethel")) {
        event.getBot().sendMessage(event.getChannel(), "Ethel is located North West of bux @-70,-92"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" ted")|| event.getMessage().equalsIgnoreCase(COMMAND+" ted")) {
        event.getBot().sendMessage(event.getChannel(), "Ted is located on the bridge west of bux @-24,10"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" alchemy")|| event.getMessage().equalsIgnoreCase(COMMAND+" alchemy")) {
        event.getBot().sendMessage(event.getChannel(), "Alchemy is located inside the mountain, entrance is on the eastern side of it @6,-62"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" banking")|| event.getMessage().equalsIgnoreCase(COMMAND+" banking")) {
        event.getBot().sendMessage(event.getChannel(), "Banking is located in the bank straight north of bux @71,154"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" mysticism")|| event.getMessage().equalsIgnoreCase(COMMAND+" mysticism")) {
        event.getBot().sendMessage(event.getChannel(), "Mysticism is located at the top of the spire on the mountain in bux @3,-61"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" mechanics")|| event.getMessage().equalsIgnoreCase(COMMAND+" mechanics")) {
        event.getBot().sendMessage(event.getChannel(), "Mechanics is located in his garage just east of bux @104,-54"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" gaming")|| event.getMessage().equalsIgnoreCase(COMMAND+" gaming")) {
        event.getBot().sendMessage(event.getChannel(), "Gaming is located in the top section of the casino just east of bux @82,-7"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" omerta")|| event.getMessage().equalsIgnoreCase(COMMAND+" omerta")) {
        event.getBot().sendMessage(event.getChannel(), "Omerta is located in the middle section (down the stairs) of the casino east of bux @84,-8"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" combat")|| event.getMessage().equalsIgnoreCase(COMMAND+" combat")) {
        event.getBot().sendMessage(event.getChannel(), "Combat is located in the fightclub (down the stairs in the gentlemans club) under the casino east of bux @82,8"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" teaching")|| event.getMessage().equalsIgnoreCase(COMMAND+" teaching")) {
        event.getBot().sendMessage(event.getChannel(), "Teaching is located in the school south of bux @48,162"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" control")|| event.getMessage().equalsIgnoreCase(COMMAND+" control")) {
        event.getBot().sendMessage(event.getChannel(), "control is located in the town hall just south after the arch in bux @0,40"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" zoning")|| event.getMessage().equalsIgnoreCase(COMMAND+" zoning")) {
        event.getBot().sendMessage(event.getChannel(), "Zoning is located in the upper floor of the town hall, just south after the arch in bux @5,21"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" storage")|| event.getMessage().equalsIgnoreCase(COMMAND+" storage")) {
        event.getBot().sendMessage(event.getChannel(), "Storage is located in a mountain north of bux, entrace on sides, @-3,-144"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" demolition")|| event.getMessage().equalsIgnoreCase(COMMAND+" demolition")) {
        event.getBot().sendMessage(event.getChannel(), "Demolition is located in a ravine south east of bux @166,157"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" gathering")|| event.getMessage().equalsIgnoreCase(COMMAND+" gathering")) {
        event.getBot().sendMessage(event.getChannel(), "Gathering is located in a windmill South west of bux @65,155"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" husbandry")|| event.getMessage().equalsIgnoreCase(COMMAND+" husbandry")) {
        event.getBot().sendMessage(event.getChannel(), "Husbandry is located near a lake South west of bux @-124,73"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" travel")|| event.getMessage().equalsIgnoreCase(COMMAND+" travel")) {
        event.getBot().sendMessage(event.getChannel(), "Travel is located in an airplane West of bux @-95,18"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" trading")|| event.getMessage().equalsIgnoreCase(COMMAND+" trading")) {
        event.getBot().sendMessage(event.getChannel(), "Trading is located on the first left floor of the mall Nort west of bux @-146,-150"); }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+COMMAND+" shopkeeping")|| event.getMessage().equalsIgnoreCase(COMMAND+" shopkeeping")) {
        event.getBot().sendMessage(event.getChannel(), "Shopkeeping is located on the ground right floor of the mall north west of bux @-100,-150"); }
        
            if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": " +COMMAND+ " list") || event.getMessage().equalsIgnoreCase(COMMAND + " list")) {
                event.getBot().sendMessage(event.getChannel(), NPCLIST+".");
            }
            
            for (String color : colors) {
                if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith(": "+color) || event.getMessage().equalsIgnoreCase(color)) {
                    event.getBot().sendMessage(event.getChannel(), COLOUR);
                }
            }
        if (event.getUser().getNick().equalsIgnoreCase("DaizNaew") && event.getMessage().equalsIgnoreCase("!on")) {
            event.getBot().sendNotice(event.getUser(), "Activating");
            DaizBot.setActivated(true);
        }
        
        if (event.getUser().getNick().equalsIgnoreCase(MASTER) && event.getMessage().toLowerCase().endsWith("!forum")|| event.getMessage().equalsIgnoreCase("!forum")) {
            event.getBot().sendMessage(event.getChannel(), "&6You can find our forum thread here: &9"+ "http://www.buxville.net/xf/threads/venice-settlement.26834/");
        }
    }
}