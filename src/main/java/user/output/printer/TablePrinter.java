package user.output.printer;

import table.TableArray;
import user.io.wrapper.IOEntity;

public class TablePrinter {
  
  public static void printTable(final TableArray tableArray, final IOEntity ioEntity) {
    final int tableSizeOnX = tableArray.getTableSizeOnX();
    final int tableSizeOnY = tableArray.getTableSizeOnY();
    
    final int maxCountOfNumbers = getMaxCountOfNumbers(tableSizeOnY);
    
    final int realCountOfSigns = getRealCountOfSigns(tableSizeOnY, maxCountOfNumbers);
    final StringBuilder emptyLine = createLineWithHorizontalBars(realCountOfSigns);
    
    for (int y = tableSizeOnY - 1; y >= 0; y--) {
      StringBuilder rowToPrint = new StringBuilder(realCountOfSigns);
      for (int x = 0; x < tableSizeOnX; x++) {
        String cellToPrint = prepareCellToPrint(tableArray, maxCountOfNumbers, x, y);
        rowToPrint.append(cellToPrint);
      }
      rowToPrint.deleteCharAt(rowToPrint.length() - 1);
      ioEntity.acceptOutput(rowToPrint.toString());
      if (y != 0) {
        ioEntity.acceptOutput(emptyLine.toString());
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
  
  private static String prepareCellToPrint(final TableArray tableArray, final int maxCountOfNumbers, int x, int y) {
    String cellToPrint = "";
    String signAt = tableArray.getSignAt(x, y);
    
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
