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
//  @Option(names = {"-n", "--name"}, description = "name of the build parent dir")
//  String name  = "";
//
//  @Option(names = {"-b", "--branch"}, description = "Desired branch to build.")
//  String branch = "";
  @Parameters(index = "0", description = "Repository URL to be cloned.")
  private String repoUrl;

  @Override
  public void run() {
//    HandleRepo.handleRepo(repoUrl);
    String name = GetName.getDirName();
    System.out.println(name);
  }
}
