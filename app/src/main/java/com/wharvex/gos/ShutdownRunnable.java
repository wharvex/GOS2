package com.wharvex.gos;

public class ShutdownRunnable implements Runnable {
  @Override
  public void run() {
    GOSLoggerSingleton.getInstance().writeToFile("</records>");
  }
}
