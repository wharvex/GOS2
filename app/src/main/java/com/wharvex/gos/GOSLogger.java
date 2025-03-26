package com.wharvex.gos;

import java.io.FileOutputStream;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class GOSLogger {
  public static void logMain(String message) {
    var xml = getLogXML(GOSLogDomain.MAIN, GOSLogLevel.INFO,
        new TwoStackFrameWrappers(5, 4), message);
    writeToFile(xml);
  }

  private static String getLogXML(GOSLogDomain domain, GOSLogLevel level,
                                  TwoStackFrameWrappers stackFrames,
                                  String message) {
    StringBuilder sb = new StringBuilder(500);
    sb.append("<record>\n");

    Instant instant = Instant.now();

    sb.append("  <date>");
    DateTimeFormatter.ISO_INSTANT.formatTo(instant, sb);
    sb.append("</date>\n");

    sb.append("  <logger>");
    sb.append(domain);
    sb.append("</logger>\n");

    sb.append("  <level>");
    sb.append(level);
    sb.append("</level>\n");

    sb.append("  <prevClass>");
    sb.append(stackFrames.getFirstClassName());
    sb.append("</prevClass>\n");

    sb.append("  <prevMethod>");
    sb.append(stackFrames.getFirstMethodName());
    sb.append("</prevMethod>\n");

    sb.append("  <class>");
    sb.append(stackFrames.getSecondClassName());
    sb.append("</class>\n");

    sb.append("  <method>");
    sb.append(stackFrames.getSecondMethodName());
    sb.append("</method>\n");

    sb.append("  <thread>");
    sb.append(Thread.currentThread().getName());
    sb.append("</thread>\n");

    sb.append("  <message>");
    sb.append(message);
    sb.append("</message>");
    sb.append("\n");
    sb.append("</record>\n");
    return sb.toString();
  }

  private static void writeToFile(String message) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        GOSConfigSingleton.getInstance().getLogFile(), false)) {
      fileOutputStream.write((message + "\n").getBytes());
    } catch (Exception e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
