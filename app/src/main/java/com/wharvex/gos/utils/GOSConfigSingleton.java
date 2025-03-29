package com.wharvex.gos.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class GOSConfigSingleton {
  private static GOSConfigSingleton instance = null;

  public File getLogFile() {
    return logFile;
  }

  private final File logFile;

  private GOSConfigSingleton() {
    var logFilePath = Path.of(
        System.getProperty("user.home") + File.separator + "gos2.log");
    try {
      Files.deleteIfExists(logFilePath);
    } catch (Exception e) {
      System.err.println("Error deleting old log file: " + e.getMessage());
    }
    logFile = logFilePath.toFile();
  }

  public static GOSConfigSingleton getInstance() {
    if (instance == null) {
      instance = new GOSConfigSingleton();
    }
    return instance;
  }
}
