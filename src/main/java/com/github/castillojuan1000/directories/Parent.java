package com.github.castillojuan1000.directories;
import com.github.castillojuan1000.Utils.GetMetadata;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Parent {
  public static void createParentDirectory(String parentDirName){
    String getCurrentPath = System.getProperty("user.dir");
    //set BUILDS BASE PATH
    System.setProperty("BUILDS_BASE_PATH", getCurrentPath+"/"+"USER_BUILDS");


    //get timestamp in milliseconds
    Date date = new Date();
    long timeMilli = date.getTime();

    //crates parent, workspace and logs dirs
    String parentDirPath = getCurrentPath+"/"+"USER_BUILDS"+"/"+parentDirName+ "_" +timeMilli;
    System.setProperty("BUILD_PARENT_PATH", parentDirPath);

    new File(parentDirPath).mkdirs();

    Workspace.createWorkspaceDir(parentDirPath);
    Logs.createLogsDir(parentDirPath);

    //gets metadata
    try {
      GetMetadata.getBuildMetadata(parentDirPath);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
