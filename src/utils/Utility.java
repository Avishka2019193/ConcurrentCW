package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


//Print give a local time when  it is executed.
public class Utility {

    public static String getCurrentDateTime(){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
        LocalDateTime now =LocalDateTime.now();
        return(dtf.format(now));
    }

    public static  long generateRandomWaitTime(){
        return  new Random().nextInt(1000)+1000;
    }


}