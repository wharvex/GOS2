package com.wharvex.gos.ui;

import com.wharvex.gos.cpuland.BootloaderSingleton_cpuland;

import java.awt.event.ActionListener;

public abstract class AbstractAcitonListener_ui implements ActionListener {
  protected BootloaderSingleton_cpuland bootloader;

  public AbstractAcitonListener_ui() {
    bootloader = BootloaderSingleton_cpuland.getInstance();
  }

}
