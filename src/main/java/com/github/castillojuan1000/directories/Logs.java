package com.github.castillojuan1000.directories;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.io.File;

public class Logs {
  private static final Logger logger = Logger.getLogger(Logs.class.getName());
  private static FileHandler fileHandler;

  public static void createLogsDir(String parentDirPath){
    new File(parentDirPath+"/logs").mkdirs();
    String buildLogsPath = parentDirPath+"/logs";
    System.setProperty("BUILD_LOGS_PATH", buildLogsPath);


      try {
        // Create a file handler to log to a logs file
        fileHandler = new FileHandler(buildLogsPath+"/build_logs.log", true);
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

      String tempLogFile = "tempLogs.log";
      String localLogFile = buildLogsPath+"/build_logs.log";

    try {
      // Open the first log file for reading
      FileInputStream fis = new FileInputStream(tempLogFile);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis));

      // Open the second log file for appending
      FileWriter fw = new FileWriter(localLogFile, true);
      BufferedWriter bw = new BufferedWriter(fw);

      // Read each line from the first log file and write it to the second log file
      String line;
      while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
      }

      // Close the files
      br.close();
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    File file = new File(tempLogFile);
    if(file.exists()){
      logger.info("Temp logs file deleted and build logs file created.");
      file.delete();
    }else{
      logger.warning("Temp file was NOT deleted.");
    }


  }

  public static Logger localLogger() {
    return logger;
  }
}
