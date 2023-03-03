package com.github.castillojuan1000.Utils;

import java.lang.reflect.Field;
import java.util.Map;

public class SystemUtil {
  public static void setEnv(String key, String value) {
    try {
      Map<String, String> env = System.getenv();
      Class<?> cl = env.getClass();
      Field field = cl.getDeclaredField("m");
      field.setAccessible(true);
      Map<String, String> writableEnv = (Map<String, String>) field.get(env);
      writableEnv.put(key, value);
    } catch (Exception e) {
      throw new IllegalStateException("Failed to set environment variable", e);
    }
  }
  //TODO: This class might need to be deleted, it solves the issue but throw warning errors,
  //TODO: a different approach will be worked on.
  //https://docs.oracle.com/en/java/javase/11/tools/java.html#GUID-3B1CE181-CD30-4178-9602-230B800D4FAE

  //How to use it
  //setting env variables
    //SystemUtil.setEnv("BUILDER_WORKSPACE_DIR", parentDirPath+"/workspace");
  //String workspacePath = System.getenv("BUILDER_WORKSPACE_DIR");
}
