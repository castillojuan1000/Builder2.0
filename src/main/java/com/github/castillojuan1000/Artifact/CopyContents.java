package com.github.castillojuan1000.Artifact;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.github.castillojuan1000.directories.Logs;
import java.util.logging.Logger;

public class CopyContents {
  public static void CopyMetadata(){
    //logs
    Logger localLogger = Logs.localLogger();

    //destination
    Path artifactDirPath = Paths.get(System.getProperty("BUILDER_ARTIFACT_DIR"));

    //source
    String parentDirPath = System.getProperty("BUILD_PARENT_PATH");
    Path metaDataFile = Paths.get(parentDirPath+"/"+"metadata.json");

    //copy
    try {
      Files.copy(metaDataFile, artifactDirPath.resolve(metaDataFile.getFileName()));
      localLogger.info("Meatadata file copied successfully.");
    } catch (IOException e) {
      localLogger.severe("Error copying metadata file: " + e.getMessage());
    }

  }
  public static void CopyBinary(){
    //logs
    Logger localLogger = Logs.localLogger();

    String workSpaceDirPath = System.getProperty("BUILD_WORKSPACE_PATH");
    String targetDirPath = workSpaceDirPath+"/target";

    File jarFile = findJarFile(targetDirPath);

    if (jarFile != null) {
      localLogger.info("Found jar file: " + jarFile.getAbsolutePath());

      //destination
      Path artifactDirPath = Paths.get(System.getProperty("BUILDER_ARTIFACT_DIR"));
      //source
      Path jarFilepath = Paths.get(jarFile.getAbsolutePath());

      //copy
      try {
        Files.copy(jarFilepath, artifactDirPath.resolve(jarFilepath.getFileName()));
        localLogger.info("Jar file copied successfully.");
      } catch (IOException e) {
        localLogger.severe("Error copying file: " + e.getMessage());
      }

    } else {
      localLogger.severe("No jar file found in directory: " + targetDirPath);
    }


  }

  public static File findJarFile(String dirPath) {
    File dir = new File(dirPath);
    if (!dir.isDirectory()) {
      throw new IllegalArgumentException("Provided path is not a directory.");
    }

    File[] files = dir.listFiles();
    for (File file : files) {
      if (file.getName().endsWith(".jar")) {
        return file;
      }
    }

    return null;
  }

}
