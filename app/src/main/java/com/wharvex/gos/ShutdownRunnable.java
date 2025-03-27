package com.wharvex.gos;

public class ShutdownRunnable implements Runnable {
  private final String message;

  public ShutdownRunnable(String message) {
    this.message = message;
  }

  @Override
  public void run() {
    System.out.println(message);
  }
}
