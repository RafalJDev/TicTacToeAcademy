package table;

import coordinates.Coordinates;
import player.Player;

public final class Table {
  
  char[][] gameTable;
  
  //TODO to other class/enum or passed as parameter
  final int howMuchSignsToWin = 3;
  
  char signToFillTableWith;
  
  private Table(int tableSize, char signToFillTableWith) {
    gameTable = new char[tableSize][tableSize];
    this.signToFillTableWith = signToFillTableWith;
  
    fillTableWithUnderScores();
  }
  
  public void fillTableWithUnderScores() {
  
    for (int x = 0; x < gameTable.length; x++) {
      for (int y = 0; y < gameTable.length; y++) {
        gameTable[x][y] = signToFillTableWith;
      }
    }
  }
  
  public static Table of(int tableSize, char signToFillTableWith) {
    
    if (tableSize < 3) {
      throw new IllegalArgumentException("Table can't be: " + tableSize);
    }
    return new Table(tableSize, signToFillTableWith);
  }
  
  public void ticTacMove(Coordinates coordinates, Player currentPlayer) {
    
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    
    char currentPlayerSign = currentPlayer.toChar();
    gameTable[xPosition][yPosition] = currentPlayerSign;
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
  
  public char getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition];
  }
  
  public char getSignAt(Coordinates coordinates) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    return getSignAt(xPosition, yPosition);
  }
  
  public int getGameTableSize() {
    return gameTable.length;
  }
  
  public char getSignToFillTableWith() {
    return signToFillTableWith;
  }
}