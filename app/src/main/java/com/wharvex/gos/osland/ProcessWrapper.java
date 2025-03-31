package com.wharvex.gos.osland;

import com.wharvex.gos.utils.GOSLogger;
import com.wharvex.gos.kernelland.KernelProcess;
import com.wharvex.gos.userland.GoodbyeWorldProcess;
import com.wharvex.gos.userland.HelloWorldProcess;

import java.util.UUID;

/**
 * This class is an alternative to storing a Stoppable's thread in the
 * Stoppable impl itself. I wanted an alternative to avoid "this-escape" in
 * the constructor of a Stoppable impl when instantiating the thread.
 */
public class ProcessWrapper {
  private Thread thread;
  private Stoppable task;
  private String name;

  public ProcessWrapper(ProcessType processType) {
    var uuidSubstring = UUID.randomUUID().toString().substring(0, 8);
    name = processType.getTypeName() + "_" + uuidSubstring;
    switch (processType) {
      case HELLOWORLD:
        task = new HelloWorldProcess(name);
        break;
      case GOODBYEWORLD:
        task = new GoodbyeWorldProcess(name);
        break;
      case KERNEL:
        task = new KernelProcess(name);
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown process type: " + processType);
    }
    thread = new Thread(task, name);
  }

  public ProcessWrapper(Class<? extends AbstractProcess> processClass) {
    var uuidSubstring = UUID.randomUUID().toString().substring(0, 8);
    name = processClass.getName() + "_" + uuidSubstring;
    try {
      task = processClass.getDeclaredConstructor(String.class)
          .newInstance(name);
    } catch (Exception e) {
      throw new RuntimeException("Failed to create process instance", e);
    }
    thread = new Thread(task, name);
  }

  public void init() {
    GOSLogger.logMain("Initting process: " + name);
    thread.start();
  }

  public void start() {
    task.start();
  }

  public void requestStop() {
  }
}
