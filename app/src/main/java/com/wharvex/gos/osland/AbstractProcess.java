package com.wharvex.gos.osland;

import com.wharvex.gos.utils.GOSLogger;

import java.util.UUID;

public abstract class AbstractProcess implements Stoppable {
  protected final OwnedBinarySemaphore semaphore;
  private final String threadName;

  public AbstractProcess(String threadNameBase) {
    this.threadName = threadNameBase + "_" + getUUIDFragment();
    semaphore = new OwnedBinarySemaphore(threadName);
  }

  @Override
  public String getThreadName() {
    return threadName;
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

  public static String getUUIDFragment() {
    return UUID.randomUUID().toString().substring(0, 8);
  }

  @Override
  public void requestStop() {
  }
}
