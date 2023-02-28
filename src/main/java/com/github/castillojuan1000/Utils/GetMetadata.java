package com.github.castillojuan1000.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import static java.util.Map.entry;


public class GetMetadata {
  public static void getBuildMetadata(String buildPath) throws IOException {
     String timestamp = getFormattedDateTime();
     String IP = getIP();
     String userName = System.getProperty("user.name");
     String homeDir = System.getProperty("user.home");

     //todo: delete this line

    Map<String, String> buildMetaData = Map.ofEntries(
        entry("userName", userName),
        entry("homeDir", homeDir),
        entry("timestamp",timestamp),
        entry("ip", IP)
    );

    OutputMetadata(buildPath,buildMetaData);
  }

  static String getIP(){
    try {
      InetAddress ip = InetAddress.getLocalHost();
      return ip.getHostAddress();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getFormattedDateTime() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MMM-yy HH:mm:ss");
    return now.format(formatter);
  }

  public static void OutputMetadata(String path, Map<String, String> allData) throws IOException {
    ObjectMapper jsonMapper = new ObjectMapper();

    byte[] jsonData = jsonMapper.writeValueAsBytes(allData);

    Files.write(new File(path + "/metadata.json").toPath(), jsonData);

    // Handling exceptions
    if (Files.notExists(new File(path + "/metadata.json").toPath())) {
      System.err.println("JSON Metadata creation unsuccessful.");
      throw new IOException("JSON Metadata creation unsuccessful.");
    }

  }


}
