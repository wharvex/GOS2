package com.wharvex.gos.utils;

public class ShutdownRunnable implements Runnable {
  @Override
  public void run() {
    GOSLoggerSingleton.getInstance().writeToFile("</records>");
  }
}
