package fa.training.util;

import org.apache.log4j.Logger;

public class Log4J {
    private static Logger logger;

    public static Logger getLogger(){
        if(logger == null){
            logger = Logger.getLogger(Log4J.class);
        }
        return logger;
    }
}
