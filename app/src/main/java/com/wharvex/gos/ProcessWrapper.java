package com.wharvex.gos;

import java.util.UUID;

public class ProcessWrapper {
  private Thread thread;
  private Stoppable task;
  private String name;

  public ProcessWrapper(ProcessType processType) {
    var uuidSubstring = UUID.randomUUID().toString().substring(0, 8);
    name = processType.getTypeName() + "_" + uuidSubstring;
    switch (processType) {
      case USERLAND:
        task = new UserlandProcess(name);
        break;
      case KERNEL:
        task = new KernelProcess(name);
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown process type: " + processType);
    }
    thread = new Thread(task, name);
  }

  public void init() {
    thread.start();
  }

  public void start() {
    task.start();
  }
}
