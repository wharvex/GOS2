package com.wharvex.gos.osland;

public enum ProcessType {
  HELLOWORLD("helloWorldProcess"),
  GOODBYEWORLD("goodbyeWorldProcess"),
  KERNEL("kernelProcess");

  private final String typeName;

  ProcessType(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return typeName;
  }
}
