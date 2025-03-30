package com.wharvex.gos.cpuland;

import com.wharvex.gos.osland.OS;

public class Bootloader {
  public static void startOS() {
    OS.loadKernel();
  }

  public static void requestShutdown() {
    // Placeholder for shutdown logic.
    Runtime.getRuntime().exit(0);
  }
}
