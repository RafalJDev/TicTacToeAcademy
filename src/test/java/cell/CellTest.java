package cell;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import table.Table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CellTest {
  
  Table table;
  
  @BeforeMethod
  public void setUp() {
    table = Table.of(3);
  }
  
  @Test
  public void of_createCell_thenCellNotNull() {
    Cell cell = Cell.of(1, "X");
    
    assertNotNull(cell);
  }
  
  @Test
  public void getXPosition_positiveCellNumber_thenCorrect() {
    
    Cell cell = Cell.of(3, "X");
    
    int xPosition = cell.getXPosition(getSize());
    
    int expectedXPosition = getExpectedXPosition(cell);
    assertEquals(xPosition, expectedXPosition);
  }
  
  @Test
  public void getXPosition_negativeCellNumbernegativeIsPossible_causeThereIsSeparateClassForCheckingInput() {
    
    Cell cell = Cell.of(-1, "X");
    
    int xPosition = cell.getXPosition(getSize());
    
    int expectedXPosition = getExpectedXPosition(cell);
    assertEquals(xPosition, expectedXPosition);
  }
  
  @Test
  public void getXPosition_cellNumberBiggerThenTableSize_causeThereIsSeparateClassForCheckingInput() {
    
    Cell cell = Cell.of(10, "X");
    
    int xPosition = cell.getXPosition(getSize());
    
    int expectedXPosition = getExpectedXPosition(cell);
    assertEquals(xPosition, expectedXPosition);
  }
  
  @Test
  public void getYPosition_positiveCellNumber_thenCorrect() {
    
    Cell cell = Cell.of(3, "X");
    
    int yPosition = cell.getYPosition(getSize());
    
    int expectedYPosition = getExpectedYPosition(cell);
    assertEquals(yPosition, expectedYPosition);
  }
  
  @Test
  public void getYPosition_negativeCellNumbernegativeIsPossible_causeThereIsSeparateClassForCheckingInput() {
    
    Cell cell = Cell.of(-1, "X");
    
    int yPosition = cell.getYPosition(getSize());
    
    int expectedYPosition = getExpectedYPosition(cell);
    assertEquals(yPosition, expectedYPosition);
  }
  
  @Test
  public void getYPosition_cellNumberBiggerThenTableSize_causeThereIsSeparateClassForCheckingInput() {
    
    Cell cell = Cell.of(10, "X");
    
    int yPosition = cell.getYPosition(getSize());
    
    int expectedYPosition = getExpectedYPosition(cell);
    assertEquals(yPosition, expectedYPosition);
  }
  
  private int getSize() {
    return table.getGameTableSize();
  }
  
  private int getExpectedXPosition(Cell cell) {
    return (cell.getCellNumber() - 1) / getSize();
  }
  
  private int getExpectedYPosition(Cell cell) {
    return (cell.getCellNumber() - 1) % getSize();
  }
}