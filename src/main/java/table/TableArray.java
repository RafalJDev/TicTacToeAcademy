package table;

import cell.Cell;
import player.Player;
import table.wrapper.TableConfiguration;
import table.wrapper.TableData;
import table.wrapper.TableSize;

public final class TableArray {
  
  private TableData tableData;
  private Cell[][] gameTable;
  
  private TableArray(TableSize tableSize, int howMuchSignsToWin) {
    tableData = new TableData(new TableConfiguration(tableSize, howMuchSignsToWin));
    
    gameTable = Cell.ofArray(tableSize);
    
    fillTableWithNumbers();
  }
  
  public static TableArray of(TableSize tableSize, int howMuchSignsToWin) {
    return new TableArray(tableSize, howMuchSignsToWin);
  }
  
  public static TableArray ofSquareTable(int tableSize) {
    return of(new TableSize(tableSize, tableSize), 3);
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition].sign;
  }
  
  public String getSignAt(Cell cell) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnY());
    return getSignAt(xPosition, yPosition);
  }
  
  private void fillTableWithNumbers() {
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
