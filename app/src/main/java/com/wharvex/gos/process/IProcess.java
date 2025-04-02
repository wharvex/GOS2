package com.wharvex.gos.process;

public interface IProcess extends Runnable {
  /**
   * When overriding this method, call "acquire" on a private
   * OwnedBinarySemaphore instance in the implementing class.
   * <p>
   * This method should be called from the thread that runs this runnable.
   */
  void stop();

  /**
   * When overriding this method, call "release" on a private
   * OwnedBinarySemaphore instance in the implementing class.
   * <p>
   * This should be called from a different thread.
   */
  void start();

  void requestStop();

  String getThreadName();
}
