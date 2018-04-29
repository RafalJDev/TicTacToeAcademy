package table;

import org.testng.annotations.Test;
import player.Player;

import static org.testng.Assert.assertEquals;

public class TableTest {
  
  Table table;
  Coordinates coordinates;
  char playerChar;
  
  final String signToFillTableWith = " ";
  
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Table can't be: " + 2)
  public void createNewTable_withIllegalArgument_thenException() {
    
    int toSmallTableSize = 2;
    table = Table.of(toSmallTableSize, signToFillTableWith);
  }
  
  @Test
  public void createNewTable_correctSize() {
  
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
  
    int gameTableSize = table.getGameTableSize();
  
    int expectedSize = 3;
    assertEquals(gameTableSize, expectedSize);
  }
  
  @Test
  public void createNewTable_try() {
    
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
  }
  
  @Test
  public void createNewTable_shouldContainUnderscore_inTheMiddle() {
    
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
  
    String signInTheMiddleOfArray = table.getSignAt(1, 1);
  
    assertEquals(signInTheMiddleOfArray, signToFillTableWith);
  }
  
  @Test
  public void ticTacMove_typicalSituation_firstMove_expectXAtPosition() {
  
    prepareTypicalTableAndMakeMove();
    
    String signAt = table.getSignAt(coordinates);
  
    playerChar = 'X';
    assertEquals(signAt, playerChar);
  }
  
  @Test
  public void getHorizontalRow_typicalSituation_provideInt() {
    
    prepareTypicalTableAndMakeMove();
    
    String horizontalRow = table.getHorizontalRow(1);
    
    String expectedRow = " X ";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getHorizontalRow_typicalSituation_provideCoordinate() {
    
    prepareTypicalTableAndMakeMove(1, 0);
    
    String horizontalRow = table.getHorizontalRow(coordinates);
    
    String expectedRow = " X ";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getVerticalColumn_typicalSituation_provideInt() {
    
    prepareTypicalTableAndMakeMove(1, 0);
    
    String horizontalRow = table.getVerticalColumn(1);
    
    String expectedRow = "X  ";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getVerticalColumn_typicalSituation_provideCoordinate() {
    
    prepareTypicalTableAndMakeMove(1, 0);
    
    String horizontalRow = table.getVerticalColumn(coordinates);
    
    String expectedRow = "X  ";
    assertEquals(horizontalRow, expectedRow);
  }
  
  void prepareTypicalTableAndMakeMove(int xPosition, int yPosition) {
    
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
    
    coordinates = Coordinates.of(xPosition, yPosition);
    Player player = Player.X;
  
    table.ticTacMove(coordinates, player);
  }
  
  private void prepareTypicalTableAndMakeMove() {
    prepareTypicalTableAndMakeMove(1, 1);
  }
}