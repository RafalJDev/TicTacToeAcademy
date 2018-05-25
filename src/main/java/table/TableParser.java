package table;

import cell.Cell;

import java.util.function.ToIntBiFunction;

public class TableParser {
  
  private TableArray tableArray;
  
  public TableParser(TableArray tableArray) {
    this.tableArray = tableArray;
  }
  
  public String getVerticalColumn(final int xPosition) {
    StringBuilder horizontalSurroundings = new StringBuilder(tableArray.getHowMuchSignsToWin());
    for (int i = 0; i < tableArray.getTableSizeOnY(); i++) {
      horizontalSurroundings.append(tableArray.getSignAt(xPosition, i));
    }
    return horizontalSurroundings.toString();
  }
  
  public String getVerticalColumn(Cell cell) {
    int xPosition = cell.getXPosition(tableArray.getTableSizeOnX());
    return getVerticalColumn(xPosition);
  }
  
  public String getHorizontalRow(final int yPosition) {
    StringBuilder line = new StringBuilder();
  
    for (int i = 0; i < tableArray.getTableSizeOnX(); i++) {
    
      line.append(tableArray.getSignAt(i, yPosition));
    }
    
    return line.toString();
  }
  
  public String getHorizontalRow(Cell coordinates) {
    int yPosition = coordinates.getYPosition(tableArray.getTableSizeOnY());
    
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
    final int xPosition = cell.getXPosition(tableArray.getTableSizeOnX());
    final int yPosition = cell.getYPosition(tableArray.getTableSizeOnY());
  
    final int leftBoundaryOfSignsToWin = -tableArray.getHowMuchSignsToWin() + 1;
  
    final int signCountAroundProvidedCell = tableArray.getHowMuchSignsToWin() * 2 - 1;
    StringBuilder diagonalLine = new StringBuilder(signCountAroundProvidedCell);
    for (int position = leftBoundaryOfSignsToWin; position < tableArray.getHowMuchSignsToWin(); position++) {
      int currentXPosition = xPosition + position;
      int currentYPosition = currentYPositionFunction.applyAsInt(yPosition, position);
      
      if (checkIfPositionIsCorrectOnX(currentXPosition) && checkIfPositionIsCorrectOnY(currentYPosition)) {
        diagonalLine.append(tableArray.getSignAt(currentXPosition, currentYPosition));
      }
    }
    return diagonalLine.toString();
  }
  
  private boolean checkIfPositionIsCorrectOnX(int positionOnX) {
    return positionOnX >= 0 && positionOnX < tableArray.getTableSizeOnX();
  }
  
  private boolean checkIfPositionIsCorrectOnY(int positionOnY) {
    return positionOnY >= 0 && positionOnY < tableArray.getTableSizeOnY();
  }
}
