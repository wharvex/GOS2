package com.wharvex.gos;

import java.io.FileOutputStream;

public class GOSLogger {
  public static void log(String message) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        GOSConfigSingleton.getInstance().getLogFile(), false)) {
      fileOutputStream.write((message + "\n").getBytes());
    } catch (Exception e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
