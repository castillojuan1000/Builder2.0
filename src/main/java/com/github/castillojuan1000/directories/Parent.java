package com.github.castillojuan1000.directories;
import java.io.File;

public class Parent {
  //todo: find out what static means
  static String getCurrentPath = System.getProperty("user.dir");


  public static void createParentDirectory(){
    //todo: get parent directory path
    //crates parent, workspace and logs dirs
    new File(getCurrentPath+"/parent_dir").mkdirs();
    Workspace.createWorkspaceDir(getCurrentPath+"/parent_dir");
    Logs.createLogsDir(getCurrentPath+"/parent_dir");
  }

}
