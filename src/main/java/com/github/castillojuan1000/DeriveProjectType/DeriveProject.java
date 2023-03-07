package com.github.castillojuan1000.DeriveProjectType;

public class DeriveProject {
  public static void deriveProject(){
    String language = DeriveLanguage.deriveLanguage();

    switch (language) {
      case "Java":
        System.out.println("THIS IS A JAVA PROJECT");
        break;
      default:
        System.out.println("This language is not support at the moment :(");
    }
  }

}
