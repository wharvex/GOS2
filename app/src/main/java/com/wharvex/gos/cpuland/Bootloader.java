package com.wharvex.gos.cpuland;

import com.wharvex.gos.osland.OS;
import com.wharvex.gos.osland.ProcessType;
import com.wharvex.gos.osland.ProcessWrapper;

public class Bootloader {
  public static void startOS() {
    OS.loadKernel();
  }

  public static void requestShutdown() {
    // Placeholder for shutdown logic.
    Runtime.getRuntime().exit(0);
  }
}
