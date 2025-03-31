package com.wharvex.gos.kernelland;

import com.wharvex.gos.utils.GOSLogger;

import java.util.TimerTask;

public class TimerTaskExt extends TimerTask {
  @Override
  public void run() {
    var x = Scheduler.getCurrentProcess();
    if (x != null) {
      x.requestStop();
    } else {
      GOSLogger.logMain("No current process found");
    }
  }
}
