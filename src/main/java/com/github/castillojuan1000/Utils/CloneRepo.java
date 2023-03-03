package com.github.castillojuan1000.Utils;

import java.io.IOException;

public class CloneRepo {
  public static void cloneRepo() throws IOException, InterruptedException {
    String buildWorkspacePath = System.getProperty("BUILD_WORKSPACE_PATH");
    String repoURL = System.getProperty("REPO_URL");

    String[] command = {"git", "clone", repoURL, buildWorkspacePath};
    Process process = Runtime.getRuntime().exec(command);
    process.waitFor();
  }

}
