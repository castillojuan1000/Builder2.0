package com.github.castillojuan1000.directories;

import java.io.File;

public class Workspace {

  public static void createWorkspaceDir(String parentDirPath){
    new File(parentDirPath+"/workspace").mkdirs();
  }

}
