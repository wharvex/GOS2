package com.wharvex.gos.osland;

public class OS {
  private static ProcessWrapper kernelProcess;

  public static void loadKernel() {
    kernelProcess = new ProcessWrapper(ProcessType.KERNEL);
    kernelProcess.init();
    kernelProcess.start();
  }
}
