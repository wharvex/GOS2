/*
 * This source file was generated by the Gradle 'init' task
 */
package com.wharvex.gos;

public class App {
  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    var app = new App();
    System.out.println(app.getGreeting());
    GOSLogger.logMain(app.getGreeting());
    Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownRunnable()));
  }
}
