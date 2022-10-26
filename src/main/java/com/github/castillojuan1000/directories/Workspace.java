package com.github.castillojuan1000.directories;

import java.io.File;
import java.util.Map;

public class Workspace {

  public static void createWorkspaceDir(String parentDirPath)  {
    new File(parentDirPath+"/workspace").mkdirs();

    //setting env variables
    ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "SET");
    Map<String, String> envMap = pb.environment();
    envMap.put("BUILDER_WORKSPACE_DIR", "myEnvVariableExample");

  }

}
