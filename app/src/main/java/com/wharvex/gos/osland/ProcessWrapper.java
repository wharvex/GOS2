package com.wharvex.gos.osland;

import com.wharvex.gos.utils.GOSLogger;

/**
 * This class is an alternative to storing a Stoppable's thread in the
 * Stoppable impl itself. I wanted an alternative to avoid "this-escape" in
 * the constructor of a Stoppable impl when instantiating the thread.
 */
public class ProcessWrapper {
  private Thread thread;
  private Stoppable task;
  private String threadName;

  public ProcessWrapper(Stoppable task) {
    this.task = task;
    thread = new Thread(task, task.getThreadName());
  }

  public ProcessWrapper() {
    task = getKernelProcess();
    thread = new Thread(task, task.getThreadName());
  }

  private Stoppable getKernelProcess() {
    try {
      var kernelClass =
          Class.forName("com.wharvex.gos.kernelland.KernelProcess");
      var kernelConstructor = kernelClass.getConstructor();
      return (Stoppable) kernelConstructor.newInstance();
    } catch (Exception e) {
      GOSLogger.logMain("bad");
      throw new RuntimeException(e);
    }
  }

  public void init() {
    GOSLogger.logMain("Initting process: " + threadName);
    thread.start();
  }

  public void start() {
    task.start();
  }

  public void requestStop() {
  }
}
