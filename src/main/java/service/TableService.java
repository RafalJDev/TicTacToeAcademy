package service;

import cell.Cell;
import player.Player;
import table.entity.wrapper.TableData;

public class TableService {
  
  private TableData tableData;
  private Cell[][] gameTable;
  
  public void ticTacMove(Cell cell, Player currentPlayer) {
    int xPosition = cell.getXPosition(getTableSizeOnX());
    int yPosition = cell.getYPosition(getTableSizeOnX());
    
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
