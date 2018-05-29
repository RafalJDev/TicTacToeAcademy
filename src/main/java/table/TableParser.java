package table;

import cell.Cell;

import java.util.function.ToIntBiFunction;

public class TableParser {
  
  private Table table;
  private int howMuchSignsToWin;
  
  public TableParser(Table table) {
    this.table = table;
    howMuchSignsToWin = table.getHowMuchSignsToWin();
  }
  
  public String getVerticalColumn(final int xPosition) {
  
    StringBuilder horizontalSurroundings = new StringBuilder(howMuchSignsToWin);
    for (int i = 0; i < table.getTableSizeOnY(); i++) {
      horizontalSurroundings.append(table.getSignAt(xPosition, i));
    }
    return horizontalSurroundings.toString();
  }
  
  public String getVerticalColumn(Cell cell) {
    int xPosition = cell.getXPosition(table.getTableSizeOnX());
    return getVerticalColumn(xPosition);
  }
  
  public String getHorizontalRow(final int yPosition) {
    StringBuilder line = new StringBuilder();
  
    for (int i = 0; i < table.getTableSizeOnX(); i++) {
      line.append(table.getSignAt(i, yPosition));
    }
    
    return line.toString();
  }
  
  public String getHorizontalRow(Cell coordinates) {
    int yPosition = coordinates.getYPosition(table.getTableSizeOnY());
    
    return getHorizontalRow(yPosition);
  }
  
  public String getLeftDiagonalLine(final Cell cell) {
    ToIntBiFunction<Integer, Integer> sumFunction = (integer, integer2) -> integer + integer2;
    return getDiagonal(cell, sumFunction);
  }
  
  public String getRightDiagonalLine(final Cell cell) {
    ToIntBiFunction<Integer, Integer> diffFunction = (integer, integer2) -> integer - integer2;
    return getDiagonal(cell, diffFunction);
  }
  
  private String getDiagonal(final Cell cell, final ToIntBiFunction<Integer, Integer> currentYPositionFunction) {
    final int xPosition = cell.getXPosition(table.getTableSizeOnX());
    final int yPosition = cell.getYPosition(table.getTableSizeOnY());
  
    final int leftBoundaryOfSignsToWin = -howMuchSignsToWin + 1;
  
    final int signCountAroundProvidedCell = howMuchSignsToWin * 2 - 1;
    StringBuilder diagonalLine = new StringBuilder(signCountAroundProvidedCell);
    for (int position = leftBoundaryOfSignsToWin; position < howMuchSignsToWin; position++) {
      int currentXPosition = xPosition + position;
      int currentYPosition = currentYPositionFunction.applyAsInt(yPosition, position);
      
      appendSignIfCorrect(diagonalLine, currentXPosition, currentYPosition);
    }
    return diagonalLine.toString();
  }
  
  private void appendSignIfCorrect(StringBuilder diagonalLine, int currentXPosition, int currentYPosition) {
    if (checkIfPositionsAreCorrect(currentXPosition, currentYPosition)) {
      diagonalLine.append(table.getSignAt(currentXPosition, currentYPosition));
    }
  }
  
  private boolean checkIfPositionsAreCorrect(int currentXPosition, int currentYPosition) {
    return checkIfPositionIsCorrect(currentXPosition, table.getTableSizeOnX())
        && checkIfPositionIsCorrect(currentYPosition, table.getTableSizeOnY());
  }
  
  private boolean checkIfPositionIsCorrect(int position, int tableSizeOnThis) {
    return (position >= 0)
        && (position < tableSizeOnThis);
  }
}
