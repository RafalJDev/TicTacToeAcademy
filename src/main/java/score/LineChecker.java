package score;

import cell.Cell;
import table.Table;

public class LineChecker {
  
  private static String regexForWinner;
  
  public static boolean isThereWinningLine(Table table, Cell currentCell) {
    
    prepareRegexForWinner(table, currentCell);
    
    return isThereWinnerOnVertical(table, currentCell) ||
        isThereWinnerOnHorizontal(table, currentCell) ||
        isThereWinnerOnDiagonal(table, currentCell);
  }
  
  public static void prepareRegexForWinner(Table table, Cell currentCell) {
    String playerSign = currentCell.sign;
    String anything = ".*";
    String numberOfSignToWin = String.valueOf(table.getHowMuchSignsToWin());
    String winningSequence = playerSign + "{" + numberOfSignToWin + "}";
    regexForWinner = anything + winningSequence + anything;
  }
  
  public static boolean isThereWinnerOnVertical(Table table, Cell cell) {
    String verticalColumn = table.getVerticalColumn(cell);
    return isWinnerOnThisLine(verticalColumn);
  }
  
  public static boolean isThereWinnerOnHorizontal(Table table, Cell cell) {
    String horizontalRow = table.getHorizontalRow(cell);
    return isWinnerOnThisLine(horizontalRow);
  }
  
  public static boolean isThereWinnerOnDiagonal(Table table, Cell cell) {
    String diagonalRow = table.getLeftDiagonalLine(cell);
    return isWinnerOnThisLine(diagonalRow);
  }
  
  private static boolean isWinnerOnThisLine(String lineToString) {
    return lineToString.matches(regexForWinner);
  }
  
  public static String getRegexForWinner() {
    return regexForWinner;
  }
}
