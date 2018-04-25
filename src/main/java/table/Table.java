package table;

import coordinates.Coordinates;

public final class Table {
  
  char[][] gameTable;
  
  //TODO to other class/enum or passed as parameter
  final int howMuchSignsToWin = 3;
  
  private Table(int tableSize) {
    gameTable = new char[tableSize][tableSize];
  
    fillTableWithUnderScores();
  }
  
  public void fillTableWithUnderScores() {
    char underscore = '_';
    for (int x = 0; x < gameTable.length; x++) {
      for (int y = 0; y < gameTable.length; y++) {
        gameTable[x][y] = underscore;
      }
    }
  }
  
  public static Table createNewTable(int tableSize) {
  
    if (tableSize < 3) {
      throw new IllegalArgumentException("Table can't be: " + tableSize);
    }
    return new Table(tableSize);
  }
  
  public void ticTacMove(Coordinates coordinates, char currentPlayerSign) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    
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
  
  public char[] getVerticalRow(int xPosition) {
    return gameTable[xPosition];
  }
  
  public char[] getVerticalRow(Coordinates coordinates) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    return getVerticalRow(xPosition);
  }
  
  public char getSign(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition];
  }
  
  public char getSign(Coordinates coordinates) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    return gameTable[xPosition][yPosition];
  }
  
  public int getGameTableSize() {
    return gameTable.length;
  }
}
