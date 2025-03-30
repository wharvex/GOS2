package com.wharvex.gos.userland;

import com.wharvex.gos.utils.GOSLogger;

public class HelloWorldProcess extends AbstractUserlandProcess {
  public HelloWorldProcess(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    GOSLogger.logMain(
        "semaphore permits before stop: " + semaphore.availablePermits());
    stop();
    GOSLogger.logMain(
        "semaphore permits after stop: " + semaphore.availablePermits());
  }
}
