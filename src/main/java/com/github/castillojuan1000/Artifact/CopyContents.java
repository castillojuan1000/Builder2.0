package com.github.castillojuan1000.Artifact;
import com.github.castillojuan1000.DeriveProjectType.DeriveLanguage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.github.castillojuan1000.directories.Logs;
import java.util.logging.Logger;

public class CopyContents {
  public static void CopyMetadata(){
    //logs
    String language = DeriveLanguage.deriveLanguage();
    Logger localLogger = Logs.localLogger();

    //destination
    Path artifactDirPath = Paths.get(System.getProperty("BUILDER_ARTIFACT_DIR"));

    //source
    String parentDirPath = System.getProperty("BUILD_PARENT_PATH");
    Path metaDataFile = Paths.get(parentDirPath+"/"+"metadata.json");

    //copy
    try {
      Files.copy(metaDataFile, artifactDirPath.resolve(metaDataFile.getFileName()));
      localLogger.info("File copied successfully.");
    } catch (IOException e) {
      localLogger.severe("Error copying file: " + e.getMessage());
    }

  }

}
