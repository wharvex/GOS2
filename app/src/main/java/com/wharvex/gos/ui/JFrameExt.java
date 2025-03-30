package com.wharvex.gos.ui;

import com.wharvex.gos.App;
import com.wharvex.gos.cpuland.Bootloader;

import javax.swing.*;
import java.awt.*;

public class JFrameExt extends JFrame {
  private JTextArea console;
  private JButton startOSButton;
  private JButton shutdownButton;
  private static JFrameExt instance;

  private JFrameExt() {
    initialize();
  }

  private void initialize() {
    // Configure frame.
    setTitle("CPU Land");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Create/configure components.
    console = new JTextArea();
    console.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(console);
    startOSButton = new JButton("Start OS");
    shutdownButton = new JButton("Request Shutdown");
    startOSButton.setEnabled(true);
    shutdownButton.setEnabled(false);

    // Create/configure/add control panel; add scroll pane.
    JPanel controlPanel = new JPanel();
    controlPanel.add(startOSButton);
    controlPanel.add(shutdownButton);
    add(controlPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);

    // Add event listeners.
    startOSButton.addActionListener(e -> Bootloader.startOS());
    shutdownButton.addActionListener(e -> Bootloader.requestShutdown());
  }

  public static JFrameExt getInstance() {
    if (instance == null) {
      instance = new JFrameExt();
    }
    return instance;
  }

  public void writeToConsole(String message) {
    console.append(message + "\n");
    console.setCaretPosition(console.getDocument().getLength());
  }
}
