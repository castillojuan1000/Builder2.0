package com.github.castillojuan1000.DeriveProjectType;
import com.github.castillojuan1000.Compile.Java;
import com.github.castillojuan1000.directories.Logs;
import java.util.logging.Logger;


public class DeriveProject {
  public static void deriveProject(){
    String language = DeriveLanguage.deriveLanguage();
    Logger localLogger = Logs.localLogger();

    switch (language) {
      case "Java":
        localLogger.info("Java project detected.");
        //compiles java project
        try{
          localLogger.info("Compiling Java project.");
          Java.Java();
        }catch (Exception e){
          localLogger.severe("Failed compiling Java project.");
          System.out.println(e.getMessage());
        }

        break;
      default:
        localLogger.warning("This language is not supported at the moment.");
    }
  }

}
