package cell;

import table.wrapper.TableSize;

/**
 * Created by Jaszczynski.Rafal on 27.04.2018.
 */
public final class Cell {
  
  public String sign;
  private int cellNumber;
  
  private Cell(int cellNumber, String sign) {
    this.cellNumber = cellNumber;
    this.sign = sign;
  }
  
  public static Cell of(int cellNumber, String sign) {
    return new Cell(cellNumber, sign);
  }
  
  public static Cell[][] ofArray(TableSize tableSize) {
    int tableSizeOnX = tableSize.getTableSizeOnX();
    int tableSizeOnY = tableSize.getTableSizeOnY();
    return new Cell[tableSizeOnX][tableSizeOnY];
  }
  
  public int getXPosition(int tableSizeOnX) {
    return (cellNumber - 1) % tableSizeOnX;
  }
  
  public int getYPosition(int tableSizeOnY) {
    
    return (cellNumber - 1) / tableSizeOnY;
  }
  
  public int getCellNumber() {
    return cellNumber;
  }
  
}
