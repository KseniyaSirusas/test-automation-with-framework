package commonact;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log {
    private static Logger log = Logger.getLogger(String.valueOf(Log.class));
public static Logger getLog(){

    PropertyConfigurator.configure("log4j.properties");
   return log;

}

}
