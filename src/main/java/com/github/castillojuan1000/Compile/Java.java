package com.github.castillojuan1000.Compile;
import java.io.File;
import java.io.IOException;

public class Java {
  public static void Java() throws IOException {
    String workspacePath = System.getProperty("BUILD_WORKSPACE_PATH");

    ProcessBuilder processBuilder = new ProcessBuilder("mvn", "clean", "install");
    processBuilder.directory(new File(workspacePath));
    Process process = processBuilder.start();

  }
}
