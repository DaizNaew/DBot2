package dbot2.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.ocpsoft.pretty.time.Duration;
import org.ocpsoft.pretty.time.PrettyTime;

public class BuxAPI
{

    private static final String BUXAPI_KEY = "KpYLIMmfAW"; // DaizNaew's personal key, just try to steal this you fuckers.

    private static final String BUXAPI_URL = "http://www.buxville.net/buxapi3/buxapi.php";
    private static XmlRpcClient client = new XmlRpcClient();

    private static XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

    static {
        try {
            config.setServerURL(new URL(BUXAPI_URL));
        } catch (MalformedURLException e)
        {
        }
        client.setConfig(config);
    }

    
    public static String getPlayerMoney(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        double balance = Double.parseDouble(String.valueOf(client.execute("player.money", params)));
        DecimalFormat formatter = new DecimalFormat("#,###,###.##");
        return balance != -1 ? formatter.format(balance) : "playerDoesntExist";
    }

    public static String getPlayerRank(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        String rankName = String.valueOf(client.execute("player.rank", params));
        String caste = "Error";
        String rank = "Error";
        switch (rankName)
        {
            //Traders
            case "Hussler":
                caste = "Trader";
                rank = "1";
                break;
            case "Vendor":
                caste = "Trader";
                rank = "2";
                break;
            case "Merchant":
                caste = "Trader";
                rank = "3";
                break;
            case "Mogul":
                rank = "4";
                caste = "Trader";
                break;
            case "CEO":
                rank = "5";
                caste = "Trader";
                break;
            case "President":
                caste = "Trader";
                rank = "6";
                break;
            case "Chairman":
                caste = "Trader";
                rank = "7";
                break;
            //Constructors
            case "Tradesman":
                caste = "Constructor";
                rank = "1";
                break;
            case "Foreman":
                caste = "Constructor";
                rank = "2";
                break;
            case "Contractor":
                caste = "Constructor";
                rank = "3";
                break;
            case "Architect":
                caste = "Constructor";
                rank = "4";
                break;
            case "Visionary":
                caste = "Constructor";
                rank = "5";
                break;
            case "Genius":
                caste = "Constructor";
                rank = "6";
                break;
            case "Prodigy":
                caste = "Constructor";
                rank = "7";
                break;
            //Politicians
            case "Intern":
                caste = "Politician";
                rank = "1";
                break;
            case "Teacher":
                caste = "Politician";
                rank = "2";
                break;
            case "Regent":
                caste = "Politician";
                rank = "3";
                break;
            case "Senator":
                caste = "Politician";
                rank = "4";
                break;
            case "Consul":
                caste = "Politician";
                rank = "5";
                break;
            case "Ambassador":
                caste = "Politician";
                rank = "6";
                break;
            case "Emissary":
                caste = "Politician";
                rank = "7";
                break;
            //Peasant
            case "-1":
                rankName = "Peasant";
                caste = "Shitty";
                rank = "0";
                break;
            //Rank 8
            default:
                caste = "Oberboss";
                rank = "8";
                break;
        }
        return rankName + " (" + caste + " Caste, Rank " + rank + ")"; 
    }
    
    public static String getPlayerTown(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        String town = String.valueOf(client.execute("player.town", params));
        return !town.equals("0") ? town : "No Town";
    }
    
    public static String getPlayerGoblin(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        return String.valueOf(client.execute("player.goblin", params));
    }
    
    public static String getPlayerVacation(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        return String.valueOf(client.execute("player.vacation", params)).equalsIgnoreCase("1") ? "Yes" : "No";
    }
    
    public static String[] getPlayerStats() throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY };
        Object[] stats = (Object[]) client.execute("player.stats", params);
        String[] returnValue = new String[stats.length];
        for (int i = 0; i < stats.length; i++)
        {
            returnValue[i] = String.valueOf(stats[i]);
        }
        return returnValue;
    }
    
    public static String[] getQuestables() throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY };
        Object[] questables = (Object[]) client.execute("general.questables", params);
        String[] returnValue = new String[questables.length];
        for (int i = 0; i < questables.length; i++)
        {
            returnValue[i] = String.valueOf(questables[i]);
        }
        return returnValue;
    }

    public static String getPlayerSeen(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        long seen = Integer.valueOf(String.valueOf(client.execute("player.seen", params)));
        if (seen > 0)
        {
            Date date = new Date(seen * 1000);
            PrettyTime pt = new PrettyTime();
            List<Duration> durations = pt.calculatePreciseDuration(date);
            String formatted = "";
            for (int i = 0; i < durations.size(); i++)
            {
                long quantity = Math.abs(durations.get(i).getQuantity());
                String name = durations.get(i).getUnit().getName();
                if (i != durations.size() - 1) formatted += quantity + " " + name + (quantity > 1 ? "s " : " ");
            }
            if (formatted.endsWith(" ")) formatted = formatted.substring(0, formatted.length() - 1);
            return formatted + " ago";
        } else if (seen == 0)
        {
            return "Online";
        } else
        {
            return "Never Seen";
        }
    }

    public static String getPlayerVote(String playerName) throws XmlRpcException
    {
        Object[] params = new Object[] { BUXAPI_KEY, playerName };
        int secondsLeft = (int) client.execute("player.vote", params);
        return NumberMethods.secondsToHHMMSS(secondsLeft);
    }
}