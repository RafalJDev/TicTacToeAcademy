package table;

import cell.Cell;
import player.Player;

import java.util.function.ToIntBiFunction;

public final class Table {
  
  //TODO to other class/enum or passed as parameter
  public final int howMuchSignsToWin = 3;
  private final int tableSize;
  private Cell[][] gameTable;
  private int filledCells = 0;
  
  private Table(int tableSize) {
    
    this.tableSize = tableSize;
    gameTable = new Cell[tableSize][tableSize];
    
    fillTableWithNumbers();
  }
  
  public static Table of(int tableSize) {
    
    //TODO put checker somewhere else
    if (tableSize < 3) {
      throw new IllegalArgumentException("Table can't be: " + tableSize);
    }
    return new Table(tableSize);
  }
  
  public void fillTableWithNumbers() {
    
    int numberToFillCellWith = 1;
    for (int x = 0; x < gameTable.length; x++) {
      for (int y = 0; y < gameTable.length; y++) {
        gameTable[x][y] = Cell.of(numberToFillCellWith, String.valueOf(numberToFillCellWith++));
      }
    }
  }
  
  public void ticTacMove(Cell cell, Player currentPlayer) {
    
    int xPosition = cell.getXPosition(tableSize);
    int yPosition = cell.getYPosition(tableSize);
    
    String currentPlayerSign = currentPlayer.toString();
    gameTable[xPosition][yPosition].sign = currentPlayerSign;
    filledCells++;
  }
  
  public String getVerticalColumn(final int yPosition) {
    
    String horizontalSurroundings = "";
    for (int i = 0; i < gameTable.length; i++) {
      horizontalSurroundings += gameTable[i][yPosition].sign;
    }
    
    return horizontalSurroundings;
  }
  
  public String getVerticalColumn(Cell coordinates) {
    int yPosition = coordinates.getYPosition(tableSize);
    return getVerticalColumn(yPosition);
  }
  
  public String getHorizontalRow(final int xPosition) {
    String line = "";
    for (Cell cell : gameTable[xPosition]) {
      line += cell.sign;
    }
    return line;
  }
  
  public String getHorizontalRow(Cell coordinates) {
    int xPosition = coordinates.getXPosition(tableSize);
    return getHorizontalRow(xPosition);
  }
  
  public String getLeftDiagonalLine(final Cell cell) {
    return getDiagonal(cell, kurwaDodatnia());
  }
  
  public String getRightDiagonalLine(final Cell cell) {
    return getDiagonal(cell, kurwaUjemna());
  }
  
  private String getDiagonal(final Cell cell, final ToIntBiFunction<Integer, Integer> currentYPositionFunction) {
    final int yPosition = cell.getYPosition(tableSize);
    final int xPosition = cell.getXPosition(tableSize);
    
    final int leftBoundaryOfSignsToWin = -howMuchSignsToWin + 1;
    
    int signCountAroundProvidedCell = howMuchSignsToWin * 2 - 1;
    StringBuilder diagonalLine = new StringBuilder(signCountAroundProvidedCell);
    for (int position = leftBoundaryOfSignsToWin; position < howMuchSignsToWin; position++) {
      int currentXPosition = xPosition + position;
      int currentYPosition = currentYPositionFunction.applyAsInt(yPosition, position);
      
      if (checkIfPositionIsCorrect(currentXPosition) && checkIfPositionIsCorrect(currentYPosition)) {
        diagonalLine.append(getSignAt(currentXPosition, currentYPosition));
      }
    }
    return diagonalLine.toString();
  }
  
  private ToIntBiFunction<Integer, Integer> kurwaDodatnia() {
    return (integer, integer2) -> integer + integer2;
  }
  
  private ToIntBiFunction<Integer, Integer> kurwaUjemna() {
    return (integer, integer2) -> integer - integer2;
  }
  
  private boolean checkIfPositionIsCorrect(int position) {
    return position >= 0 && position < tableSize;
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition].sign;
  }
  
  public String getSignAt(Cell coordinates) {
    int xPosition = coordinates.getXPosition(tableSize);
    int yPosition = coordinates.getYPosition(tableSize);
    return getSignAt(xPosition, yPosition);
  }
  
  public int getGameTableSize() {
    return tableSize;
  }
  
  public int getFilledCells() {
    return filledCells;
  }
  
  public int getHowMuchSignsToWin() {
    return howMuchSignsToWin;
  }
  
}