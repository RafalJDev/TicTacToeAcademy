package score;

import cell.Cell;
import table.Table;
import table.TableParser;

public class LineChecker {
  
  private static String regexForWinner;
  
  private static TableParser tableParser;
  
  private LineChecker() {
  }
  
  public static boolean isThereWinningLine(Table table, Cell currentCell) {
    
    prepareChecker(table, currentCell);
    
    return isThereWinnerOnVertical(currentCell) ||
        isThereWinnerOnHorizontal(currentCell) ||
        isThereWinnerOnLeftDiagonal(currentCell) ||
        isThereWinnerOnRightDiagonal(currentCell);
  }
  
  public static void prepareChecker(Table table, Cell currentCell) {
    prepareRegexForWinner(table, currentCell);
    tableParser = new TableParser(table);
  }
  
  private static void prepareRegexForWinner(Table table, Cell currentCell) {
    String playerSign = currentCell.sign;
    String anything = ".*";
    String numberOfSignToWin = String.valueOf(table.getHowMuchSignsToWin());
    String winningSequence = playerSign + "{" + numberOfSignToWin + "}";
    regexForWinner = anything + winningSequence + anything;
  }
  
  public static boolean isThereWinnerOnVertical(Cell cell) {
    String verticalColumn = tableParser.getVerticalColumn(cell);
    return isWinnerOnThisLine(verticalColumn);
  }
  
  private static boolean isThereWinnerOnHorizontal(Cell cell) {
    String horizontalRow = tableParser.getHorizontalRow(cell);
    
    return isWinnerOnThisLine(horizontalRow);
  }
  
  private static boolean isThereWinnerOnLeftDiagonal(Cell cell) {
    String diagonalRow = tableParser.getLeftDiagonalLine(cell);
    return isWinnerOnThisLine(diagonalRow);
  }
  
  private static boolean isThereWinnerOnRightDiagonal(Cell cell) {
    String diagonalRow = tableParser.getRightDiagonalLine(cell);
    return isWinnerOnThisLine(diagonalRow);
  }
  
  private static boolean isWinnerOnThisLine(String lineToString) {
    return lineToString.matches(regexForWinner);
  }
  
  public static String getRegexForWinner() {
    return regexForWinner;
  }
}
