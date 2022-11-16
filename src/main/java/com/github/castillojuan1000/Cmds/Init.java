package com.github.castillojuan1000.Cmds;
import com.github.castillojuan1000.directories.Parent;
import com.github.castillojuan1000.directories.Workspace;
import com.github.castillojuan1000.Utils.HandleRepo;
import com.github.castillojuan1000.Utils.GetName;

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
    System.out.println("starting handling repo");
    //checks whether repo actually exists in github
    HandleRepo.handleRepo(repoUrl);

    System.out.println("starting getName");
    //determines the name of the parent dir
    String parentDirName = GetName.getDirName(dirName, repoUrl);

    System.out.println("Starting creating dirs");
    //creates dirs (parent, workspace, logs)
    Parent.createParentDirectory(parentDirName);
    System.out.println("creating dirs Done");
  }
}
