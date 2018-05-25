package score;

import cell.Cell;
import table.TableArray;
import table.TableParser;

public class LineChecker {
  
  private static String regexForWinner;
  
  private static TableParser tableParser;
  
  private LineChecker() {
  }
  
  public static boolean isThereWinningLine(TableArray tableArray, Cell currentCell) {
    
    prepareChecker(tableArray, currentCell);
    
    return isThereWinnerOnVertical(currentCell) ||
        isThereWinnerOnHorizontal(currentCell) ||
        isThereWinnerOnLeftDiagonal(currentCell) ||
        isThereWinnerOnRightDiagonal(currentCell);
  }
  
  public static void prepareChecker(TableArray tableArray, Cell currentCell) {
    prepareRegexForWinner(tableArray, currentCell);
    tableParser = new TableParser(tableArray);
  }
  
  private static void prepareRegexForWinner(TableArray tableArray, Cell currentCell) {
    String playerSign = currentCell.sign;
    String anything = ".*";
    String numberOfSignToWin = String.valueOf(tableArray.getHowMuchSignsToWin());
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
  
  //TODO maybe check here regex and return boolean ?
  public static String getRegexForWinner() {
    return regexForWinner;
  }
}
