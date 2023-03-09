package com.github.castillojuan1000.Artifact;

import java.io.File;
import java.util.Date;

public class ArtifactDir {
  public static void CreateArtifactDir(){
    String parentDir = System.getProperty("BUILD_PARENT_PATH");

    //get timestamp
    Date date = new Date();
    long timeMilli = date.getTime();

    //get and set artifact+timestamp dir path
    String artifactTimeStamp = "artifact_"+timeMilli;
    System.setProperty("BUILDER_ARTIFACT_TIMESTAMP",artifactTimeStamp);


    String artifactDirPath = parentDir+"/"+artifactTimeStamp;

    //create artifact dir
    new File(artifactDirPath).mkdirs();
  }
}
