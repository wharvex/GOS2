package com.wharvex.gos;

public class ProcessWrapper {
  private Thread thread;
  private Runnable runnable;

  public ProcessWrapper(Runnable runnable) {
    this.runnable = runnable;
    thread = new Thread(runnable);
  }
}
