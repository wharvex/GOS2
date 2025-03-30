package com.wharvex.gos.osland;

import java.util.List;

public class OS {
  private static ProcessWrapper kernelProcess;
  private static List<ContextSwitchParameter> contextSwitchParameters;

  public static void loadKernel() {
    kernelProcess = new ProcessWrapper(ProcessType.KERNEL);
    kernelProcess.init();
    kernelProcess.start();
  }
}
