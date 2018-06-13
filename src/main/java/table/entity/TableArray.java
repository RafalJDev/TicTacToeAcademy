package table.entity;

import cell.Cell;
import table.entity.wrapper.TableSize;

public class TableArray {
  
  private Cell[][] gameTable;
  
  private TableArray(int tableSizeOnX, int tableSizeOnY) {
    gameTable = new Cell[tableSizeOnX][tableSizeOnY];
    
    fillTableWithNumbers(tableSizeOnX, tableSizeOnY);
  }
  
  public static TableArray arrayOfSize(TableSize tableSize) {
    int tableSizeOnX = tableSize.getTableSizeOnX();
    int tableSizeOnY = tableSize.getTableSizeOnY();
    return new TableArray(tableSizeOnX, tableSizeOnY);
  }
  
  public String getSignAt(int xPosition, int yPosition) {
    return gameTable[xPosition][yPosition].sign;
  }
  
  private void fillTableWithNumbers(int tableSizeOnX, int tableSizeOnY) {
    int numberToFillCellWith = 1;
    for (int currentYPos = 0; currentYPos < tableSizeOnY; currentYPos++) {
      for (int currentXPos = 0; currentXPos < tableSizeOnX; currentXPos++) {
        String numberToString = String.valueOf(numberToFillCellWith);
        gameTable[currentXPos][currentYPos] = Cell.of(numberToFillCellWith, numberToString);
        numberToFillCellWith++;
      }
    }
  }
  
  private void iterateOnColumnAndFillIt(int tableSizeOnX, int currentYPos, int currentNumber) {
    for (int currentXPos = 0; currentXPos < tableSizeOnX; currentXPos++) {
      String numberToString = String.valueOf(currentNumber);
      gameTable[currentXPos][currentYPos] = Cell.of(currentNumber, numberToString);
    }
  }
  
  public void assignPlayerToCell(int xPosition, int yPosition, String currentPlayer) {
    gameTable[xPosition][yPosition].sign = currentPlayer;
  }
}
