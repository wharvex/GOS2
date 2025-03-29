package com.wharvex.gos;

import java.text.MessageFormat;
import java.util.concurrent.Semaphore;

public class OwnedBinarySemaphore extends Semaphore {
  private final String ownerThreadName;

  public OwnedBinarySemaphore(String ownerThreadName) {
    super(0);
    this.ownerThreadName = ownerThreadName;
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
      throw new IllegalStateException(
          "Semaphore has too many permits: " + availablePermits());
    }
  }

  private void validateThread() {
    if (!Thread.currentThread().getName().equals(ownerThreadName)) {
      throw new IllegalStateException(MessageFormat.format(
          "Semaphore expected owner thread {0}, found {1}.",
          ownerThreadName, Thread.currentThread().getName()));
    }
  }
}
