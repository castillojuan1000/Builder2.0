package com.github.castillojuan1000.directories;

import java.io.File;

public class Logs {
  public static void createLogsDir(String parentDirPath){
    new File(parentDirPath+"/logs").mkdirs();
  }
}
