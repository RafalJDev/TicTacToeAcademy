package cell;

/**
 * Created by Jaszczynski.Rafal on 27.04.2018.
 */
public class Cell {
  
  private int cellNumber;
  public String sign;
  
  private Cell(int cellNumber, String sign) {
    this.cellNumber = cellNumber;
    this.sign = sign;
  }
  
  public static Cell of(int cellNumber, String sign) {
    return new Cell(cellNumber, sign);
  }
  
  public int getXPosition(int tableSize) {
    return (cellNumber - 1) / tableSize;
  }
  
  public int getYPosition(int tableSize) {
    return (cellNumber - 1) % tableSize;
  }
  
  public int getCellNumber() {
    return cellNumber;
  }
  
}
