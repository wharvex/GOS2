package com.wharvex.gos.osland;

import java.util.List;

public class OSSingleton_osland {
  private static OSSingleton_osland instance;
  private static ProcessWrapper kernelProcess;
  private static List<ContextSwitchParameter> contextSwitchParameters;

  private OSSingleton_osland() {
  }

  public static OSSingleton_osland getInstance() {
    if (instance == null) {
      instance = new OSSingleton_osland();
    }
    return instance;
  }

  public void loadKernel() {
    kernelProcess = new ProcessWrapper();
    kernelProcess.init();
    kernelProcess.start();
  }

  public void createProcess(Stoppable process) {
    var processWrapper = new ProcessWrapper(process);
    switchProcess(CallType.CREATE_PROCESS);
  }

  public void switchProcess(CallType callType) {

  }
}
