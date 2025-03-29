package com.wharvex.gos;

public class UserlandProcess implements Stoppable {
  private final OwnedBinarySemaphore semaphore;

  public UserlandProcess(String threadName) {
    semaphore = new OwnedBinarySemaphore(threadName);
  }

  @Override
  public void run() {
    stop();
    System.out.println("UserlandProcess is running");
  }

  @Override
  public void stop() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println("UserlandProcess interrupted");
    }
    System.out.println("UserlandProcess stopped");
  }

  @Override
  public void start() {
    semaphore.release();
    System.out.println("UserlandProcess started");
  }
}
