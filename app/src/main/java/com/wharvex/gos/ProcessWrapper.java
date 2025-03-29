package com.wharvex.gos;

import java.util.UUID;

public class ProcessWrapper {
  private Thread thread;
  private Stoppable runnable;
  private String name;

  public ProcessWrapper(Stoppable runnable, String nameBase) {
    var uuidSubstring = UUID.randomUUID().toString().substring(0, 8);
    name = nameBase + "_" + uuidSubstring;
    this.runnable = runnable;
    thread = new Thread(runnable, name);
  }

  public void init() {
    thread.start();
  }

  public void start() {
    runnable.start();
  }
}
