package com.github.castillojuan1000.Compile;
import com.github.castillojuan1000.Artifact.ArtifactDir;
import java.io.File;
import java.io.IOException;

public class Java {
  public static void Java() throws IOException, InterruptedException {
    String workspacePath = System.getProperty("BUILD_WORKSPACE_PATH");

    //compiles code and creates binary file
    ProcessBuilder processBuilder = new ProcessBuilder("mvn", "clean", "install");
    processBuilder.directory(new File(workspacePath));
    Process process = processBuilder.start();

    //wait for process to finish
    int exitCode = process.waitFor();

    if (exitCode == 0) {
      //creates artifact dir
      ArtifactDir.CreateArtifactDir();
    }

  }
}
