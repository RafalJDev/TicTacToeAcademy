package table;

import coordinates.Coordinates;

import java.util.Arrays;
import java.util.stream.Stream;

public final class Table {
  
  char[][] gameTable;
  
  //TODO to other class/enum
  final int howMuchSignsToWin = 3;
  
  private Table(int tableSize) {
    gameTable = new char[tableSize][tableSize];
    Arrays.stream(gameTable).forEach(chars -> chars);
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
  
  public void ticTac(Coordinates coordinates, char currentPlayerSign) {
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
  
    gameTable[xPosition][yPosition] = currentPlayerSign;
  }
  
  public String getHorizontalSurroundings(Coordinates currentCoordinates) {
    
    Stream<char[]> stream = Arrays.stream(gameTable);
    stream.forEach(System.out::println);
    return null;
  }
  
  public char[] getVertivalRow(int xPosition) {
    return gameTable[xPosition];
  }
  
  public char[][] getGameTable() {
    return gameTable;
  }
  
}
