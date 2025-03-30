package com.wharvex.gos.utils;

import com.wharvex.gos.App;

import javax.swing.*;
import java.awt.*;

public class JFrameExt extends JFrame {
  private JTextArea console;
  private JButton kernelLoadButton;
  private JButton shutdownButton;

  public JFrameExt() {
    initialize();
  }

  private void initialize() {
    // Configure frame.
    setTitle("OS Simulator");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Create/configure components.
    console = new JTextArea();
    console.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(console);
    kernelLoadButton = new JButton("Load Kernel");
    shutdownButton = new JButton("Request Shutdown");
    kernelLoadButton.setEnabled(true);
    shutdownButton.setEnabled(false);

    // Create/configure/add control panel; add scroll pane.
    JPanel controlPanel = new JPanel();
    controlPanel.add(kernelLoadButton);
    controlPanel.add(shutdownButton);
    add(controlPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);

    // Add event listeners.
    kernelLoadButton.addActionListener(e -> App.loadKernel());
    shutdownButton.addActionListener(e -> App.requestShutdown());
  }
}
