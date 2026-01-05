package utilities;

import java.io.IOException;
import java.util.logging.*;

public class LoggerHelper {
    private static Logger logger = Logger.getLogger(LoggerHelper.class.getName());
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("Wallet_Automation_Log.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
        }
    }

    public static void info(String message) {
        logger.info("✅ SUCCESS: " + message);
    }

    public static void error(String message, Exception e) {
        logger.severe("❌ ERROR: " + message + " | Exception: " + e.getMessage());
    }
}
