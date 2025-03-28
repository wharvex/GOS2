package com.wharvex.gos;

import java.io.File;
import java.io.FileOutputStream;

public class GOSLoggerSingleton {
  private static GOSLoggerSingleton instance = null;
  private File logFile;
  private int stackFrameLevel1;
  private int stackFrameLevel2;
  private int indentLevel1;
  private int indentLevel2;

  private GOSLoggerSingleton() {
    logFile = GOSConfigSingleton.getInstance().getLogFile();
    stackFrameLevel1 = 6;
    stackFrameLevel2 = 5;
    indentLevel1 = 2;
    indentLevel2 = 4;
    writeToFile("<records>" + "\n");
  }

  public static GOSLoggerSingleton getInstance() {
    if (instance == null) {
      instance = new GOSLoggerSingleton();
    }
    return instance;
  }

  public int getStackFrameLevel1() {
    return stackFrameLevel1;
  }

  public int getStackFrameLevel2() {
    return stackFrameLevel2;
  }

  public int getIndentLevel1() {
    return indentLevel1;
  }

  public int getIndentLevel2() {
    return indentLevel2;
  }

  public void writeToFile(String message) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(logFile,
        true)) {
      fileOutputStream.write((message).getBytes());
    } catch (Exception e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
