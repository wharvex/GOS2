package com.wharvex.gos;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class GOSLogger {
  public static void logMain(String message) {
    var xml = getLogXML(GOSLogDomain.MAIN, GOSLogLevel.INFO,
        new TwoStackFrameWrappers(5, 4), message);
    GOSLoggerSingleton.getInstance().writeToFile(xml);
  }

  private static String getLogXML(GOSLogDomain domain, GOSLogLevel level,
                                  TwoStackFrameWrappers stackFrames,
                                  String message) {
    StringBuilder sb = new StringBuilder(500);

    appendElementPartial(2, sb, "record");

    Instant instant = Instant.now();

    appendElement(4, sb, "date",
        DateTimeFormatter.ISO_INSTANT.format(instant));

    appendElement(4, sb, "logger", String.valueOf(domain));

    appendElement(4, sb, "level", String.valueOf(level));

    appendElement(4, sb, "prevClass", stackFrames.getFirstClassName());

    appendElement(4, sb, "prevMethod", stackFrames.getFirstMethodName());

    appendElement(4, sb, "class", stackFrames.getSecondClassName());

    appendElement(4, sb, "method", stackFrames.getSecondMethodName());

    appendElement(4, sb, "thread", Thread.currentThread().getName());

    appendElement(4, sb, "message", message);

    sb.append("</record>\n");
    return sb.toString();
  }

  private static void appendElement(int indentSpacesQty,
                                    @NotNull StringBuilder sb,
                                    String element,
                                    String value) {
    sb.append(" ".repeat(Math.max(0, indentSpacesQty)));
    sb.append(MessageFormat.format("<{0}>{1}</{0}>\n", element, value));
  }

  private static void appendElementPartial(int indentSpacesQty,
                                           @NotNull StringBuilder sb,
                                           String element) {
    sb.append(" ".repeat(Math.max(0, indentSpacesQty)));
    sb.append(MessageFormat.format("<{0}>\n", element));
  }
}
