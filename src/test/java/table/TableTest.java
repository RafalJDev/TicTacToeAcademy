package table;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;

import static org.testng.Assert.assertEquals;

public class TableTest {
  
  private Table table;
  private Cell cell;
  private String playerChar;
  
  private TableParser tableParser;
  
  @Test()
  public void createNewTable_correctSize() {
    
    int standardSize = 3;
    table = Table.ofSquareTable(standardSize);
  
    int gameTableSize = table.getTableSizeOnX();
    
    int expectedSize = 3;
    assertEquals(gameTableSize, expectedSize);
  }
  
  @Test
  public void createNewTable_try() {
    
    int standardSize = 3;
    table = Table.ofSquareTable(standardSize);
  }
  
  @Test
  public void createNewTable_shouldContainUnderscore_inTheMiddle() {
    
    int standardSize = 3;
    table = Table.ofSquareTable(standardSize);
  
    String numberInTheMiddleOfTable = table.getSignAt(1, 1);
    
    int countOfNumberInTable = standardSize * standardSize;
    String expectedNumber = String.valueOf((countOfNumberInTable / 2) + 1);
    
    assertEquals(numberInTheMiddleOfTable, expectedNumber);
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
    tableParser = new TableParser(table);
  
    String horizontalRow = tableParser.getHorizontalRow(1);
    
    String expectedRow = "4X6";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getHorizontalRow_typicalSituation_provideCoordinate() {
    
    prepareTableAndMakeMovesAsX(3, 3);
    tableParser = new TableParser(table);
  
    String horizontalRow = tableParser.getHorizontalRow(cell);
    
    String expectedRow = "12X";
    assertEquals(horizontalRow, expectedRow);
  }
  
  @Test
  public void getVerticalColumn_typicalSituation_provideInt() {
    
    prepareTableAndMakeMovesAsX(3, 3);
    tableParser = new TableParser(table);
  
    String verticalColumn = tableParser.getVerticalColumn(1);
    
    String expectedRow = "258";
    assertEquals(verticalColumn, expectedRow);
  }
  
  @Test
  public void getLeftDiagonalLine_threeMoves_123() {
    prepareTableAndMakeMovesAsX(3, 1, 2, 3);
    tableParser = new TableParser(table);
  
    String leftDiagonalLine = tableParser.getLeftDiagonalLine(cell);
    
    assertEquals(leftDiagonalLine, "X");
  }
  
  @Test
  public void getLeftDiagonalLine_threeMoves_456() {
    prepareTableAndMakeMovesAsX(3, 4, 5, 6);
    tableParser = new TableParser(table);
  
    String rightDiagonalLine = tableParser.getLeftDiagonalLine(cell);
    
    assertEquals(rightDiagonalLine, "2X");
  }
  
  @Test
  public void getLeftDiagonalLine_threeMoves_789() {
    prepareTableAndMakeMovesAsX(3, 7, 8, 9);
    tableParser = new TableParser(table);
  
    String rightDiagonalLine = tableParser.getLeftDiagonalLine(cell);
    
    assertEquals(rightDiagonalLine, "15X");
  }
  
  @Test
  public void getRightDiagonalLine_threeMoves_123() {
    prepareTableAndMakeMovesAsX(3, 1, 2, 3);
    tableParser = new TableParser(table);
  
    String rightDiagonalLine = tableParser.getRightDiagonalLine(cell);
  
    assertEquals(rightDiagonalLine, "75X");
  }
  
  @Test
  public void getRightDiagonalLine_threeMoves_456() {
    prepareTableAndMakeMovesAsX(3, 4, 5, 6);
    tableParser = new TableParser(table);
  
    String rightDiagonalLine = tableParser.getRightDiagonalLine(cell);
  
    assertEquals(rightDiagonalLine, "8X");
  }
  
  @Test
  public void getRightDiagonalLine_threeMoves_789() {
    prepareTableAndMakeMovesAsX(3, 7, 8, 9);
    tableParser = new TableParser(table);
  
    String rightDiagonalLine = tableParser.getRightDiagonalLine(cell);
    
    assertEquals(rightDiagonalLine, "X");
  }
  
  private void prepareTableAndMakeMovesAsPlayer(Player currentPlayer, int tableSize, int... positions) {
    table = Table.ofSquareTable(tableSize);
    
    Player player = currentPlayer;
    
    for (int currentPosition : positions) {
      cell = Cell.of(currentPosition, player.toString());
  
      table.ticTacMove(cell, player.toString());
    }
  }
  
  private void prepareTableAndMakeMovesAsX(int tableSize, int... positions) {
    prepareTableAndMakeMovesAsPlayer(Player.X, tableSize, positions);
  }
  
  private void prepareTypicalTableAndMakeMove() {
    prepareTableAndMakeMovesAsX(3, 5);
  }
}