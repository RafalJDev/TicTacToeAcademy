package user.output.printer;

import table.Table;

import java.util.function.Consumer;

public class TablePrinter {
  
  public static void printTable(final Table table, final Consumer<String> printer) {
    
    final int gameTableSize = table.getGameTableSize();
    
    int maxCountOfNumbers = getMaxCountOfNumbers(gameTableSize);
    
    final int realCountOfSigns = getRealCountOfSigns(gameTableSize, maxCountOfNumbers);
    final StringBuilder emptyLine = createLineWithHorizontalBars(realCountOfSigns);
    
    for (int x = 0; x < gameTableSize; x++) {
      StringBuilder rowToPrint = new StringBuilder(realCountOfSigns);
      for (int y = 0; y < gameTableSize; y++) {
        String cellToPrint = prepareCellToPrint(table, maxCountOfNumbers, x, y);
        rowToPrint.append(cellToPrint);
      }
      rowToPrint.deleteCharAt(rowToPrint.length() - 1);
      printer.accept(rowToPrint.toString());
      if (x != (gameTableSize - 1)) {
        printer.accept(emptyLine.toString());
      }
    }
  }
  
  private static int getRealCountOfSigns(int gameTableSize, int maxCountOfNumbers) {
    return maxCountOfNumbers * gameTableSize + gameTableSize - 1;
  }
  
  private static int getMaxCountOfNumbers(int gameTableSize) {
    int countOfSignsInTable = gameTableSize * gameTableSize;
    String countToString = String.valueOf(countOfSignsInTable);
    return countToString.length();
  }
  
  public static String prepareCellToPrint(final Table table, final int maxCountOfNumbers, int x, int y) {
    
    String cellToPrint = "";
    String signAt = table.getSignAt(x, y);
    
    int signAtLength = signAt.length();
    for (int i = signAtLength; i < maxCountOfNumbers; i++) {
      cellToPrint = " " + cellToPrint;
    }
    
    String horizontalSeparator = "|";
    cellToPrint += signAt + horizontalSeparator;
    return cellToPrint;
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
