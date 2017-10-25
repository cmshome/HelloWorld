package com.lxk.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 测试log日志
 * <p>
 * @author lxk on 2017/3/9
 */
public class LogMain {
    public static void main(String[] args) {
        PropertyConfigurator.configure( "log.properties " );
        Logger logger = Logger.getLogger(LogMain.class);
        /*
            级别依次升高
         */
        logger.trace("trace ...");
        logger.debug("Debug ...");
        logger.info("Info ...");
        logger.warn("Warn ...");
        logger.error("Error ...");
        logger.fatal("Fatal ...");
    }
}
