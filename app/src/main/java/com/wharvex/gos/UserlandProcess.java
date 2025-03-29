package com.wharvex.gos;

public class UserlandProcess extends AbstractProcess {
  public UserlandProcess(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    GOSLogger.logMain("semaphore permits: " + semaphore.availablePermits());
    stop();
    GOSLogger.logMain("semaphore permits: " + semaphore.availablePermits());
    System.out.println("UserlandProcess is running");
  }
}
