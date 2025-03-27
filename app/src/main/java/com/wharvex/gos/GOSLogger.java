package com.wharvex.gos;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class GOSLogger {
  public static void logMain(String message) {
    var xml = getLogXML(GOSLogDomain.MAIN, GOSLogLevel.INFO,
        new TwoStackFrameWrappers(
            GOSLoggerSingleton.getInstance().getStackFrameLevel1(),
            GOSLoggerSingleton.getInstance().getStackFrameLevel2()),
        message);
    GOSLoggerSingleton.getInstance().writeToFile(xml);
  }

  private static String getLogXML(GOSLogDomain domain, GOSLogLevel level,
                                  @NotNull TwoStackFrameWrappers stackFrames,
                                  String message) {
    // Set up variables.
    var sb = new StringBuilder();
    var instant = DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    var il1 = GOSLoggerSingleton.getInstance().getIndentLevel1();
    var il2 = GOSLoggerSingleton.getInstance().getIndentLevel2();

    // Append record element and its sub-elements.
    appendElementPartial(il1, sb, "record", true);
    appendElement(il2, sb, "date", instant);
    appendElement(il2, sb, "logger", String.valueOf(domain));
    appendElement(il2, sb, "level", String.valueOf(level));
    appendElement(il2, sb, "prevClass", stackFrames.getFirstClassName());
    appendElement(il2, sb, "prevMethod", stackFrames.getFirstMethodName());
    appendElement(il2, sb, "class", stackFrames.getSecondClassName());
    appendElement(il2, sb, "method", stackFrames.getSecondMethodName());
    appendElement(il2, sb, "thread", Thread.currentThread().getName());
    appendElement(il2, sb, "message", message);
    appendElementPartial(il1, sb, "record", false);

    // Return the XML string.
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
                                           String element, boolean isOpen) {
    var firstBracket = isOpen ? "<" : "</";
    sb.append(" ".repeat(Math.max(0, indentSpacesQty)));
    sb.append(MessageFormat.format("{0}{1}>\n", firstBracket, element));
  }
}
