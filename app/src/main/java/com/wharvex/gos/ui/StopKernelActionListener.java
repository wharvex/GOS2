package com.wharvex.gos.ui;

import com.wharvex.gos.cpuland.BootloaderSingleton_cpuland;

import java.awt.event.ActionListener;

public class StopKernelActionListener extends AbstractAcitonListener {

  @Override
  public void actionPerformed(java.awt.event.ActionEvent e) {
    // Handle the action event for stopping the kernel
    bootloader.requestShutdown();
  }
}
