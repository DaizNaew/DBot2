package dbot2.util;

import java.util.Date;
import java.util.Random;

public class NumberMethods
{
    private static Random random = new Random(new Date().getTime());
    
    public static Random getRandom()
    {
        return random;
    }

    public static boolean isDouble(String string)
    {
        try
        {
            Double.valueOf(string);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static boolean isInteger(String string)
    {
        try
        {
            Integer.valueOf(string);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
    
    public static String secondsToHHMMSS(int input)
    {

        int hours = input / 3600,
        remainder = input % 3600,
        minutes = remainder / 60,
        seconds = remainder % 60;
    
        if (input == 0) return "0";
        return 
        (hours > 0 ? hours + " hour" + (hours > 1 ? "s " : " ") : "") + 
        (minutes > 0 ? minutes + " minute" + (minutes > 1 ? "s " : " ") : "") + 
        (seconds > 0 ? seconds + " second" + (seconds > 1 ? "s" : "") : "");
    }

    public static int negativeRandom(int low, int high)
    {

        if (low == high) return low;

        int tmp = low;
        low = high;
        high = tmp;

        int diff = high - low;

        int i = random.nextInt(diff + 1);

        return i + low;
    }
    
    public static int roll(int min, int max)
    {
        boolean negativeInvolved = min < 0 || max < 0;

        if (!negativeInvolved && min > max || negativeInvolved && min < max)
        {
            return -1;
        }
        
        if (negativeInvolved) return negativeRandom(min, max);
        else return (min + (int) (Math.random() * ((max - min) + 1)));
    }
}
