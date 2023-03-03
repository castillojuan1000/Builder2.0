package com.github.castillojuan1000.Utils;
import java.util.Objects;

public class GetName {
  public static String getDirName(String dirName, String repoUrl){
    int nameStartIndex = repoUrl.lastIndexOf('/') + 1;

    if(dirName.length() > 0){
      return dirName;
    }else{
      return repoUrl.substring(nameStartIndex);
    }
  }

}
