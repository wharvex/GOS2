package com.wharvex.gos.osland;

import java.util.List;

public class OS {
  private static ProcessWrapper kernelProcess;
  private static List<ContextSwitchParameter> contextSwitchParameters;

  public static void loadKernel() {
    kernelProcess = new ProcessWrapper();
    kernelProcess.init();
    kernelProcess.start();
  }

  public static void createProcess(Stoppable process) {
    var processWrapper = new ProcessWrapper(process);
    switchProcess(CallType.CREATE_PROCESS);
  }

  public static void switchProcess(CallType callType) {

  }
}
