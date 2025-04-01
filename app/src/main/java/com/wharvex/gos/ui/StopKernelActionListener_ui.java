package com.wharvex.gos.ui;

public class StopKernelActionListener_ui extends AbstractAcitonListener_ui {

  @Override
  public void actionPerformed(java.awt.event.ActionEvent e) {
    // Handle the action event for stopping the kernel
    bootloader.requestShutdown();
  }
}
