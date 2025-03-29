package com.wharvex.gos.kernelland;

import com.wharvex.gos.osland.AbstractProcess;
import com.wharvex.gos.GOSLogger;

public class KernelProcess extends AbstractProcess {
  public KernelProcess(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    GOSLogger.logMain(
        "semaphore permits before stop: " + semaphore.availablePermits());
    stop();
    GOSLogger.logMain(
        "semaphore permits after stop: " + semaphore.availablePermits());
    System.out.println(Thread.currentThread().getName() + " after stop");
  }
}
