package table;

import cell.Cell;
import player.Player;

public final class Table {
  
  String[][] gameTable;
  
  //TODO to other class/enum or passed as parameter
  final int howMuchSignsToWin = 3;
  
  String signToFillTableWith;
  private int filledCells=0;

  private Table(int tableSize, String signToFillTableWith) {
    gameTable = new String[tableSize][tableSize];
    this.signToFillTableWith = signToFillTableWith;
  
    fillTableWithUnderScores();
  }
  
  public void fillTableWithUnderScores() {

    int numberToFillCellWith = 1;
    for (int x = 0; x < gameTable.length; x++) {
      for (int y = 0; y < gameTable.length; y++) {
        gameTable[x][y] = String.valueOf(numberToFillCellWith++);
      }
    }
  }
  
  public static Table of(int tableSize, String signToFillTableWith) {

    //TODO put checker somewhere else
    if (tableSize < 3) {
      throw new IllegalArgumentException("Table can't be: " + tableSize);
    }
    return new Table(tableSize, signToFillTableWith);
  }
  
  public void ticTacMove(Cell cell, Player currentPlayer) {
    
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    
    String currentPlayerSign = currentPlayer.toString();
    gameTable[xPosition][yPosition] = currentPlayerSign;
    filledCells++;
  }
  
  public String getHorizontalRow(int yPosition) {
    
    String horizontalSurroundings = "";
    for (int i = 0; i < gameTable.length; i++) {
      horizontalSurroundings += gameTable[i][yPosition];
    }
    
    return horizontalSurroundings;
  }
  
  public String getHorizontalRow(Coordinates coordinates) {
    int yPosition = coordinates.getYPosition();
    return getHorizontalRow(yPosition);
  }
  
  public String getVerticalColumn(int xPosition) {
    return String.valueOf(gameTable[xPosition]);
  }
  
  public String getVerticalColumn(Coordinates coordinates) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    return getVerticalColumn(xPosition);
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition];
  }
  
  public String getSignAt(Coordinates coordinates) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    return getSignAt(xPosition, yPosition);
  }
  
  public int getGameTableSize() {
    return gameTable.length;
  }
  
  public String getSignToFillTableWith() {
    return signToFillTableWith;
  }

  public int getFilledCells() {
    return filledCells;
  }
}