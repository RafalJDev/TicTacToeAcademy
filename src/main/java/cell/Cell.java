package cell;

/**
 * Created by Jaszczynski.Rafal on 27.04.2018.
 */
public class Cell {

  int cellNumber;

  public Cell(int cellNumber) {
    this.cellNumber = cellNumber;
  }

  public Cell of(int cellNumber) {
    return new Cell(cellNumber);
  }
}
