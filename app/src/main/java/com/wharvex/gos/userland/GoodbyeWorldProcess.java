package com.wharvex.gos.userland;

import com.wharvex.gos.utils.GOSLogger;

public class GoodbyeWorldProcess extends AbstractUserlandProcess {
  public GoodbyeWorldProcess(String threadName) {
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
