package com.github.castillojuan1000.Cmds;
import com.github.castillojuan1000.DeriveProjectType.DeriveLenguage;
import com.github.castillojuan1000.directories.Parent;
import com.github.castillojuan1000.directories.Workspace;
import com.github.castillojuan1000.Utils.HandleRepo;
import com.github.castillojuan1000.Utils.GetName;
import com.github.castillojuan1000.Utils.CloneRepo;
import com.github.castillojuan1000.Logs.TempLogs;
import java.util.logging.Logger;

import java.io.IOException;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "init", description = "Initializes a project.", mixinStandardHelpOptions = true)
final public class Init implements Runnable{

  //flags
  @Option(names = {"-n", "--name"}, description = "name of the build parent dir")
  String dirName  = "";
//
//  @Option(names = {"-b", "--branch"}, description = "Desired branch to build.")
//  String branch = "";
  @Parameters(index = "0", description = "Repository URL to be cloned.")
  private String repoUrl;

  @Override
  public void run() {
//     Logger logger = TempLogs.getLogger();
//     logger.info("Initializing logs");
//
//    logger.info("Starting handling repo to determine whether repository exists or not.");
//    //checks whether repo actually exists in github
//    HandleRepo.handleRepo(repoUrl);
//    logger.info("Finished handling repository.");
//
//    logger.info("Starting getting project name.");
//    //determines the name of the parent dir
//    String parentDirName = GetName.getDirName(dirName, repoUrl);
//    logger.info("Finished getting project name.");
//
//    logger.info("Starting creating Dirs");
//    //creates dirs (parent, workspace, logs)
//    Parent.createParentDirectory(parentDirName);
//    logger.info("Finished creating Dirs");
//
//    //clone repo into workspace dir
//    try {
//      logger.info("Starting cloning repo into workspace dir.");
//      CloneRepo.cloneRepo();
//      logger.info("Finished cloning repo into workspace dir.");
//    } catch (IOException e) {
//      logger.severe("Repo was unsuccessfully cloned.");
//      e.printStackTrace();
//    } catch (InterruptedException e) {
//      logger.severe("Repo was unsuccessfully cloned.");
//      e.printStackTrace();
//    }

    DeriveLenguage.deriveLenguage();

  }
}
