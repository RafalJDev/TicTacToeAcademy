package table;

import coordinates.Coordinates;

public final class Table {
  
  char[][] gameTable;
  
  private Table(int tableSize) {
    gameTable = new char[tableSize][tableSize];
  }
  
  public static Table createNewTable(int tableSize) {
  
    if (tableSize < 3 ) {
      throw new IllegalArgumentException("Table can't be: " + tableSize);
    }
    return new Table(tableSize);
  }
  
  public int getGameTableSize() {
    return gameTable.length;
  }
  
  public void putSignToTable(Coordinates coordinates, char currentPlayerSign) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
  
    gameTable[xPosition][yPosition] = currentPlayerSign;
  }
  
}
