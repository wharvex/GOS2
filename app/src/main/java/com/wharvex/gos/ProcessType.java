package com.wharvex.gos;

public enum ProcessType {
  HELLOWORLD("helloWorldProcess"),
  KERNEL("kernelProcess");

  private final String typeName;

  ProcessType(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return typeName;
  }
}
