package com.github.castillojuan1000.Cmds;
import com.github.castillojuan1000.directories.Parent;

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

  //delete this comment
  @Override
  public void run() {
    System.out.println(repoUrl);

    Parent.createParentDirectory();
    String workspacePath = System.getenv("BUILDER_WORKSPACE_DIR");
    System.out.println("workpace: " + workspacePath);

  }
}
