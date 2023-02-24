package com.github.castillojuan1000.Utils;
import java.time.LocalDate;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetMetadata {
  public static void getBuildMetadata(){
     String timestamp = getFormattedDateTime();
     String IP = getIP();
     String userName = System.getProperty("user.name");
     String homeDir = System.getProperty("user.home");

     System.out.println(timestamp);
    System.out.println(IP);
    System.out.println(userName);
    System.out.println(homeDir);

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

}
