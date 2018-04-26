package user.output.printer;

import table.Table;

import java.util.function.Consumer;

public class TablePrinter {
  
  public static void printTable(final Table table, final Consumer<StringBuilder> printer) {
    
    final int gameTableSize = table.getGameTableSize();
    final int realCountOfSigns = (gameTableSize * 2) - 1;
    final StringBuilder emptyLine = createLineWithHorizontalBars(realCountOfSigns);
    
    for (int x = 0; x < gameTableSize; x++) {
      StringBuilder rowToPrint = new StringBuilder(realCountOfSigns);
      for (int y = 0; y < gameTableSize; y++) {
        char signAt = table.getSignAt(x, y);
        rowToPrint.append(signAt + "|");
      }
      rowToPrint.deleteCharAt(realCountOfSigns);
      printer.accept(rowToPrint);
      if (x != (gameTableSize - 1)) {
        printer.accept(emptyLine);
      }
    }
  }
  
  public static StringBuilder createLineWithHorizontalBars(final int realCountOfSigns) {
    StringBuilder whiteSpaces = new StringBuilder(realCountOfSigns);
    String horizontalBar = "-";
    for (int x = 0; x < realCountOfSigns; x++) {
      whiteSpaces.append(horizontalBar);
    }
    return whiteSpaces;
  }
}
