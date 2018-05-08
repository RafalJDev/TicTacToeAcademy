package table;

import cell.Cell;
import player.Player;

public final class Table {
  
  //TODO to other class/enum or passed as parameter
  public final int howMuchSignsToWin = 3;
  private Cell[][] gameTable;
  
  private int filledCells = 0;
  
  private Table(int tableSize) {
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
    
    int xPosition = cell.getXPosition(getGameTableSize());
    int yPosition = cell.getYPosition(getGameTableSize());
    
    String currentPlayerSign = currentPlayer.toString();
    gameTable[xPosition][yPosition].sign = currentPlayerSign;
    filledCells++;
  }
  
  public String getVerticalColumn(int yPosition) {
    
    String horizontalSurroundings = "";
    for (int i = 0; i < gameTable.length; i++) {
      horizontalSurroundings += gameTable[i][yPosition].sign;
    }
    
    return horizontalSurroundings;
  }
  
  public String getVerticalColumn(Cell coordinates) {
    int yPosition = coordinates.getYPosition(getGameTableSize());
    return getVerticalColumn(yPosition);
  }
  
  public String getHorizontalRow(int xPosition) {
    String line = "";
    for (Cell cell : gameTable[xPosition]) {
      line += cell.sign;
    }
    return line;
  }
  
  public String getHorizontalRow(Cell coordinates) {
    int xPosition = coordinates.getXPosition(getGameTableSize());
    int yPosition = coordinates.getYPosition(getGameTableSize());
    return getHorizontalRow(xPosition);
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition].sign;
  }
  
  public String getSignAt(Cell coordinates) {
    int xPosition = coordinates.getXPosition(getGameTableSize());
    int yPosition = coordinates.getYPosition(getGameTableSize());
    return getSignAt(xPosition, yPosition);
  }
  
  public int getGameTableSize() {
    return gameTable.length;
  }
  
  public int getFilledCells() {
    return filledCells;
  }
  
  public int getHowMuchSignsToWin() {
    return howMuchSignsToWin;
  }
}