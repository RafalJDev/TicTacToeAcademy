package cell;

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
  
  public int getXPosition(int tableSizeOnX) {
    return (cellNumber - 1) % tableSizeOnX;
  }
  
  public int getYPosition(int tableSizeOnX) {
    return (cellNumber - 1) / tableSizeOnX;
  }
  
  public int getCellNumber() {
    return cellNumber;
  }
  
}
