package com.wharvex.gos.osland;

import com.wharvex.gos.utils.GOSLogger;

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
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
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
  }
}
