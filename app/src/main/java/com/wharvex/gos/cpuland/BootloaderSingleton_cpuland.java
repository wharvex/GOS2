package com.wharvex.gos.cpuland;

import com.wharvex.gos.osland.OSSingleton_osland;

public class BootloaderSingleton_cpuland {
  private static BootloaderSingleton_cpuland instance;
  private OSSingleton_osland os;

  private BootloaderSingleton_cpuland() {
    os = OSSingleton_osland.getInstance();
  }

  public static BootloaderSingleton_cpuland getInstance() {
    if (instance == null) {
      instance = new BootloaderSingleton_cpuland();
    }
    return instance;
  }

  public void startOS() {
    os.loadKernel();
  }

  public void requestShutdown() {
    // Placeholder for shutdown logic.
    Runtime.getRuntime().exit(0);
  }
}
