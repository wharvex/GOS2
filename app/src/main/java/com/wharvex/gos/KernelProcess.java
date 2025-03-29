package com.wharvex.gos;

public class KernelProcess implements Stoppable {
  private final OwnedBinarySemaphore semaphore;

  public KernelProcess(String threadName) {
    semaphore = new OwnedBinarySemaphore(threadName);
  }

  @Override
  public void run() {
    stop();
    System.out.println("KernelProcess is running");
  }

  @Override
  public void stop() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("KernelProcess interrupted");
    }
    System.out.println("KernelProcess stopped");
  }

  @Override
  public void start() {
    semaphore.release();
    System.out.println("KernelProcess started");
  }
}
