/*
 * This source file was generated by the Gradle 'init' task
 */
package com.wharvex.gos;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownRunnable()));
    var app = new App();
    System.out.println(app.getGreeting());
    GOSLogger.logMain(app.getGreeting());

    // Initialize the kernel process
    var kernelProcess = new ProcessWrapper(ProcessType.KERNEL);
    kernelProcess.init();
    kernelProcess.start();

    // Initialize the userland process
    var userlandProcess = new ProcessWrapper(ProcessType.HELLOWORLD);
    userlandProcess.init();
    userlandProcess.start();
  }
}
