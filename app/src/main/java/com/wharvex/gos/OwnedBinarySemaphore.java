package com.wharvex.gos;

import java.text.MessageFormat;
import java.util.concurrent.Semaphore;

public class OwnedBinarySemaphore extends Semaphore {
  private Thread ownerThread;

  public OwnedBinarySemaphore(Thread ownerThread) {
    super(0);
    this.ownerThread = ownerThread;
  }

  @Override
  public void acquire() throws InterruptedException {
    validateThread();
    validatePermits();
    super.acquire();
  }

  @Override
  public void release() {
    validatePermits();
    super.release();
  }

  private void validatePermits() {
    if (availablePermits() > 0) {
      throw new IllegalStateException("Semaphore has too many permits");
    }
  }

  private void validateThread() {
    if (Thread.currentThread() != ownerThread) {
      throw new IllegalStateException(MessageFormat.format(
          "Semaphore expected owner thread {0}, found {1}.",
          ownerThread.getName(), Thread.currentThread().getName()));
    }
  }
}
