package com.wharvex.gos;

public interface Stoppable extends Runnable {
  void stop();

  void start();

  void init();
}
