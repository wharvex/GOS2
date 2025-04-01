package com.wharvex.gos.ui;

import com.wharvex.gos.cpuland.BootloaderSingleton_cpuland;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerImpl implements ActionListener {
  private BootloaderSingleton_cpuland bootloader;

  public ActionListenerImpl() {
    bootloader = BootloaderSingleton_cpuland.getInstance();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
