package com.github.castillojuan1000.directories;
import java.io.File;

public class Parent {
  //todo: find out
  static String getCurrentPath = System.getProperty("user.dir");


  public static void createParentDirectory(){
    System.out.println(getCurrentPath+"/parent_dir");
    new File(getCurrentPath+"/parent_dir").mkdirs();
  }

}
