package com.wharvex.gos.ui;

import java.awt.event.ActionEvent;

public class StartKernelActionListener_ui extends AbstractAcitonListener_ui {

  @Override
  public void actionPerformed(ActionEvent e) {
    bootloader.startOS();
  }
}
