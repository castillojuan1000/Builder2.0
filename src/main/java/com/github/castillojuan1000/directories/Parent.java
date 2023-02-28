package com.github.castillojuan1000.directories;
import com.github.castillojuan1000.Utils.GetMetadata;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Parent {
  //todo: this variable might need to be make global
  public static String getCurrentPath = System.getProperty("user.dir");


  public static void createParentDirectory(String parentDirName){
    //get timestamp in milliseconds
    Date date = new Date();
    long timeMilli = date.getTime();

    //crates parent, workspace and logs dirs
    new File(getCurrentPath+"/"+parentDirName+ "_" +timeMilli).mkdirs();

    Workspace.createWorkspaceDir(getCurrentPath+"/"+parentDirName+ "_" +timeMilli);
    Logs.createLogsDir(getCurrentPath+"/"+parentDirName+ "_" +timeMilli);

    try {
      GetMetadata.getBuildMetadata(getCurrentPath+"/"+parentDirName+ "_" +timeMilli);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
