package com.wharvex.gos.ui;

import java.awt.event.ActionEvent;

public class StartKernelActionListener extends AbstractAcitonListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    bootloader.startOS();
  }
}
