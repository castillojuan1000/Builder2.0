package com.github.castillojuan1000.Artifact;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ArtifactDir {
  public static void CreateArtifactDir() throws IOException {
    String parentDir = System.getProperty("BUILD_PARENT_PATH");

    //get timestamp
    Date date = new Date();
    long timeMilli = date.getTime();

    //get and set artifact+timestamp dir path
    String artifactTimeStamp = "artifact_"+timeMilli;
    System.setProperty("BUILDER_ARTIFACT_TIMESTAMP",artifactTimeStamp);

    //set artifact dir path
    String artifactDirPath = parentDir+"/"+artifactTimeStamp;
    System.setProperty("BUILDER_ARTIFACT_DIR",artifactDirPath);

    //create artifact dir
    new File(artifactDirPath).mkdirs();

    //copy contents over to artifact dir
    CopyContents.CopyMetadata();
    CopyContents.CopyBinary();
    CopyContents.CopyLogs();
    ZipArtifact.ZipArtifact();

  }
}
