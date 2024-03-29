package com.github.castillojuan1000.Logs;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class TempLogs {
  private static final Logger logger = Logger.getLogger(TempLogs.class.getName());
  private static FileHandler fileHandler;


    //create logs file
  static {
    try {
      // Create a file handler to log to a text file
      fileHandler = new FileHandler("tempLogs.log", true);
      logger.addHandler(fileHandler);

      // Set the log level and formatter
      logger.setLevel(Level.INFO);

      fileHandler.setFormatter(new SimpleFormatter() {
        private static final String format = "[%1$tF %1$tT] %2$s %n";

        @Override
        public synchronized String format(java.util.logging.LogRecord lr) {
          return String.format(format,
              lr.getMillis(),
              lr.getMessage()
          );
        }
      });

      // Remove the console handler
      logger.setUseParentHandlers(false);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    public static Logger getLogger() {
      return logger;
    }


}
