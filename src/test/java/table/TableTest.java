package table;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;

import static org.testng.Assert.assertEquals;

public class TableTest {
  
  
  Table table;
  Cell cell;
  String playerChar;
  
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Table can't be: " + 2)
  public void createNewTable_withIllegalArgument_thenException() {
    
    int toSmallTableSize = 2;
    table = Table.of(toSmallTableSize);
  }
  
  @Test()
  public void createNewTable_correctSize() {
    
    int standardSize = 3;
    table = Table.of(standardSize);
    
    int gameTableSize = table.getGameTableSize();
    
    int expectedSize = 3;
    assertEquals(gameTableSize, expectedSize);
  }
  
  @Test
  public void createNewTable_try() {
    
    int standardSize = 3;
    table = Table.of(standardSize);
  }
  
  @Test
  public void createNewTable_shouldContainUnderscore_inTheMiddle() {
    
    int standardSize = 3;
    table = Table.of(standardSize);
    
    String numberInTheMiddleOfTable = table.getSignAt(1, 1);
    
    int countOfNumberInTable = standardSize * standardSize;
    String expetedNumber = String.valueOf((countOfNumberInTable / 2) + 1);
    
    assertEquals(numberInTheMiddleOfTable, expetedNumber);
  }
  
  @Test
  public void ticTacMove_typicalSituation_firstMove_expectXAtPosition() {
    
    prepareTypicalTableAndMakeMove();
    
    String signAt = table.getSignAt(cell);
    
    playerChar = "X";
    assertEquals(signAt, playerChar);
  }
  
  @Test
  public void getHorizontalRow_typicalSituation_provideInt() {
    
    prepareTypicalTableAndMakeMove();
    
    String horizontalRow = table.getHorizontalRow(1);
    
    String expectedRow = "4X6";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getHorizontalRow_typicalSituation_provideCoordinate() {
    
    prepareTypicalTableAndMakeMove(3);
    
    String horizontalRow = table.getHorizontalRow(cell);
    
    String expectedRow = "12X";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getVerticalColumn_typicalSituation_provideInt() {
    
    prepareTypicalTableAndMakeMove(3);
    
    String verticalColumn = table.getVerticalColumn(1);
    
    String expectedRow = "258";
    assertEquals(verticalColumn, expectedRow);
  }
  
  @Test
  public void getHorizontalColumn_typicalSituation_provideCoordinate() {
    
    prepareTypicalTableAndMakeMove(3);
    
    String horizontalRow = table.getHorizontalRow(cell);
    
    String expectedRow = "12X";
    
    assertEquals(horizontalRow, expectedRow);
  }
  
  void prepareTypicalTableAndMakeMove(int position) {
    
    int standardSize = 3;
    table = Table.of(standardSize);
    
    cell = Cell.of(position, "X");
    Player player = Player.X;
    
    table.ticTacMove(cell, player);
  }
  
  private void prepareTypicalTableAndMakeMove() {
    prepareTypicalTableAndMakeMove(5);
  }
}