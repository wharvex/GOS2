package com.wharvex.gos;

public abstract class AbstractProcess implements Stoppable {
  protected final OwnedBinarySemaphore semaphore;
  private final String threadName;

  public AbstractProcess(String threadName) {
    this.threadName = threadName;
    semaphore = new OwnedBinarySemaphore(threadName);
  }

  @Override
  public void stop() {
    GOSLogger.logMain(
        "semaphore permits before acquire: " + semaphore.availablePermits());
    System.out.println(threadName + " before acquiring self");
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println(threadName + " interrupted");
    }
    GOSLogger.logMain(
        "semaphore permits after acquire: " + semaphore.availablePermits());
  }

  @Override
  public void start() {
    GOSLogger.logMain(
        "semaphore permits before release: " + semaphore.availablePermits());
    semaphore.release();
    GOSLogger.logMain(
        "semaphore permits after release: " + semaphore.availablePermits());
    System.out.println(
        Thread.currentThread().getName() + " after releasing " + threadName);
  }
}
