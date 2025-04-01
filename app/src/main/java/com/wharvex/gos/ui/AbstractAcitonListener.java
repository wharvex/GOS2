package com.wharvex.gos.ui;

import com.wharvex.gos.cpuland.BootloaderSingleton_cpuland;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractAcitonListener implements ActionListener {
  protected BootloaderSingleton_cpuland bootloader;

  public AbstractAcitonListener() {
    bootloader = BootloaderSingleton_cpuland.getInstance();
  }

}
