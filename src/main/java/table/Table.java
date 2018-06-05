package table;

import cell.Cell;
import table.entity.TableArray;
import table.entity.wrapper.TableConfiguration;
import table.entity.wrapper.TableData;
import table.entity.wrapper.TableSize;

public final class Table {
  
  private TableData tableData;
  
  private TableArray tableArray;
  
  private Table(TableSize tableSize, int howMuchSignsToWin) {
    tableData = new TableData(new TableConfiguration(tableSize, howMuchSignsToWin));

    tableArray = TableArray.arrayOfSize(tableSize);
  }
  
  public static Table of(TableSize tableSize, int howMuchSignsToWin) {
    return new Table(tableSize, howMuchSignsToWin);
  }
  
  public static Table ofSquareTable(int tableSize) {
    return of(new TableSize(tableSize, tableSize), 3);
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return tableArray.getSignAt(xPosition, yPosition);
  }
  
  public String getSignAt(Cell cell) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnX());
    return tableArray.getSignAt(xPosition, yPosition);
  }
  
  public void ticTacMove(Cell cell, String currentPlayer) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnX());
    
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
