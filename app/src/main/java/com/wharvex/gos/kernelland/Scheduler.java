package com.wharvex.gos.kernelland;

import com.wharvex.gos.osland.ProcessWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Scheduler {
  private final Timer timer;
  private final List<ProcessWrapper> processes;
  private static volatile ProcessWrapper currentProcess;

  public Scheduler() {
    timer = new Timer("timerThread");
    processes = new ArrayList<>();
  }

  public static ProcessWrapper getCurrentProcess() {
    return currentProcess;
  }

  public static void setCurrentProcess(ProcessWrapper process) {
    currentProcess = process;
  }

  public void startTimer(int delay, int period) {
    timer.schedule(new TimerTaskExt(), delay, period);
  }
}
