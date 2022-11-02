package com.github.castillojuan1000.directories;

import java.io.File;
import com.github.castillojuan1000.Utils.SystemUtil;


public class Workspace {
  public static String builderWorkspacePath;


  public static void createWorkspaceDir(String parentDirPath)  {
    new File(parentDirPath+"/workspace").mkdirs();
    builderWorkspacePath = parentDirPath+"/workspace";
  }


}
