package com.wharvex.gos.userland;

import com.wharvex.gos.osland.AbstractProcess;

public abstract class AbstractUserlandProcess extends AbstractProcess {
  public AbstractUserlandProcess(String threadName) {
    super(threadName);
  }
}
