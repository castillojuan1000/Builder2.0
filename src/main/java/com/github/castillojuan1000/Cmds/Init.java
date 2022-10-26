package com.github.castillojuan1000.Cmds;
import com.github.castillojuan1000.directories.Parent;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "init", description = "Initializes a project.", mixinStandardHelpOptions = true)
final public class Init implements Runnable{

  //flags
//  @Option(names = {"-n", "--name"}, description = "name of the build parent dir")
//  String name  = "";
//
//  @Option(names = {"-b", "--branch"}, description = "Desired branch to build.")
//  String branch = "";



  @Override
  public void run() {
    Parent.createParentDirectory();
  }
}
