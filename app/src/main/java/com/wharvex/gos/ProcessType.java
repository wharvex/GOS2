package com.wharvex.gos;

public enum ProcessType {
  USERLAND("userlandProcess"),
  KERNEL("kernelProcess");

  private final String typeName;

  ProcessType(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return typeName;
  }
}
