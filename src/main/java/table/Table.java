package table;

import cell.Cell;
import player.Player;

public final class Table {
  
  //TODO to other class/enum or passed as parameter
  private final int howMuchSignsToWin;
  
  private TableSize tableSize;
  
  private Cell[][] gameTable;
  private int filledCells = 0;
  
  private Table(TableSize tableSize, int howMuchSignsToWin) {
    this.tableSize = tableSize;
    this.howMuchSignsToWin = howMuchSignsToWin;
    
    gameTable = Cell.ofArray(tableSize);
    
    fillTableWithNumbers();
  }
  
  public static Table of(TableSize tableSize, int howMuchSignsToWin) {
    return new Table(tableSize, howMuchSignsToWin);
  }
  
  public static Table of(int tableSizeOnX, int tableSizeOnY) {
    
    //TODO probably to delete cause checking is somewhere else
    if (tableSizeOnX < 3 || tableSizeOnY < 3) {
      throw new IllegalArgumentException("Table Size cannot be less than 3");
    }
    return new Table(new TableSize(tableSizeOnX, tableSizeOnY), 3);
  }
  
  public static Table ofSquareTable(int tableSize) {
    
    //TODO probably to delete cause checking is somewhere else
    if (tableSize < 3) {
      throw new IllegalArgumentException("Table can't be: " + tableSize);
    }
    return new Table(new TableSize(tableSize, tableSize), 3);
  }
  
  public void fillTableWithNumbers() {
    
    int numberToFillCellWith = 1;
    for (int y = 0; y < getTableSizeOnX(); y++) {
      for (int x = 0; x < getTableSizeOnY(); x++) {
        gameTable[x][y] = Cell.of(numberToFillCellWith, String.valueOf(numberToFillCellWith++));
      }
    }
  }
  
  public void ticTacMove(Cell cell, Player currentPlayer) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnY());
    
    String currentPlayerSign = currentPlayer.toString();
    gameTable[xPosition][yPosition].sign = currentPlayerSign;
    filledCells++;
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition].sign;
  }
  
  public String getSignAt(Cell coordinates) {
    int xPosition = coordinates.getXPosition(getTableSizeOnX());
    int yPosition = coordinates.getYPosition(getTableSizeOnY());
    return getSignAt(xPosition, yPosition);
  }
  
  public int getTableSizeOnX() {
    return tableSize.getTableSizeOnX();
  }
  
  public int getTableSizeOnY() {
    return tableSize.getTableSizeOnY();
  }
  
  public int getCountOfSigns() {
    return getTableSizeOnX() * getTableSizeOnY();
  }
  
  public int getFilledCells() {
    return filledCells;
  }
  
  public int getHowMuchSignsToWin() {
    return howMuchSignsToWin;
  }
  
}