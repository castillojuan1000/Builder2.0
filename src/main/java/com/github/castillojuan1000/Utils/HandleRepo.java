package com.github.castillojuan1000.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HandleRepo {
  //todo: clone repo into work dir
  //todo: in the future: we need to check for a branch flag, branch name and clone that branch - capture the metadata for that branch

  public static void handleRepo(String repoUrl){
    String cmd = "git ls-remote " + repoUrl;

    String result = null;
    try (InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
        Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
      result = s.hasNext() ? s.next() : null;
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (result == null){
      System.out.println("Repo does not exists.");
      System.exit(0);
    }else{
      System.out.println(result);
    }

  }
}
