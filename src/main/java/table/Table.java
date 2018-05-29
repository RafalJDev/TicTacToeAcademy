package table;

import cell.Cell;
import table.entity.TableArray;
import table.entity.wrapper.TableConfiguration;
import table.entity.wrapper.TableData;
import table.entity.wrapper.TableSize;

public final class Table {
  
  private TableData tableData;
  
  //  private Cell[][] gameTable;
  private TableArray tableArray;
  
  private Table(TableSize tableSize, int howMuchSignsToWin) {
    tableData = new TableData(new TableConfiguration(tableSize, howMuchSignsToWin));

//    gameTable = Cell.ofArray(tableSize);
    tableArray = TableArray.arrayOfSize(tableSize);
  }
  
  public static Table of(TableSize tableSize, int howMuchSignsToWin) {
    return new Table(tableSize, howMuchSignsToWin);
  }
  
  public static Table ofSquareTable(int tableSize) {
    return of(new TableSize(tableSize, tableSize), 3);
  }

//  public String getSignAt(int xPosition, int yPosition) {
//    return gameTable[xPosition][yPosition].sign;
//  }
//
//  public String getSignAt(Cell cell) {
//    int xPosition = cell.getXPosition(getTableSizeOnX());
//    int yPosition = cell.getYPosition(getTableSizeOnY());
//    return getSignAt(xPosition, yPosition);
//  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return tableArray.getSignAt(xPosition, yPosition);
  }
  
  public String getSignAt(Cell cell) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnY());
    return tableArray.getSignAt(xPosition, yPosition);
  }

//  private void fillTableWithNumbers() {
//    int numberToFillCellWith = 1;
//    for (int y = 0; y < getTableSizeOnX(); y++) {
//      for (int x = 0; x < getTableSizeOnY(); x++) {
//        gameTable[x][y] = Cell.of(numberToFillCellWith, String.valueOf(numberToFillCellWith++));
//      }
//    }
//  }

//  public void ticTacMove(Cell cell, String currentPlayer) {
//    int xPosition = cell.getXPosition(getTableSizeOnX());
//    int yPosition = cell.getYPosition(getTableSizeOnY());
//
//    gameTable[xPosition][yPosition].sign = currentPlayer;
//    tableData.incrementFilledCells();
//  }
  
  public void ticTacMove(Cell cell, String currentPlayer) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnY());
    
    tableArray.assignPlayerToCell(xPosition, yPosition, currentPlayer);
    tableData.incrementFilledCells();
  }
  
  public int getTableSizeOnX() {
    return tableData.getTableSizeOnX();
  }
  
  public int getTableSizeOnY() {
    return tableData.getTableSizeOnY();
  }
  
  public boolean isTableFilled() {
    return tableData.isTableFilled();
  }
  
  public int getHowMuchSignsToWin() {
    return tableData.getHowMuchSignsToWin();
  }
  
}
