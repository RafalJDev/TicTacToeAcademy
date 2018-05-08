package score;

import cell.Cell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import player.Player;
import service.MoveService;
import table.Table;

import static org.testng.Assert.*;

public class LineCheckerTest {
  
  Table table;
  Player currentPlayer;
  Cell lastCell;
  
  @Test(dataProvider = "getData")
  public void instanceDbProvider(int p1, String p2) {
    System.out.println("Instance DataProvider Example: Data(" + p1 + ", " + p2 + ")");
    
  }
  
  @DataProvider
  public Object[][] getData() {
    return new Object[][]{{5, "five"}, {6, "six"}};
  }
  
  
  @Test()
  public void isThereWinningLine_twoXMovesOnHorizontal_thenNoWinner(/*boolean result, String playerSign, int...movePositions*/) {
    
    makeMoves("X", 1, 2);
    
    boolean isThereWinningRow = LineChecker.isThereWinningLine(table, lastCell);
    
    assertEquals(isThereWinningRow, false);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnHorizontal_thenThereIsWinner() {
    
    makeMoves("X", 1, 2, 3);
    
    boolean isThereWinningRow = LineChecker.isThereWinningLine(table, lastCell);
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_twoXMovesOnVertical_thenNoWinner() {
    
    makeMoves("X", 5, 2);
    
    boolean isThereWinningRow = LineChecker.isThereWinningLine(table, lastCell);
    
    assertFalse(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnVertical_thenThereIsWinner() {
    
    makeMoves("X", 5, 2, 8);
    
    boolean isThereWinningRow = LineChecker.isThereWinningLine(table, lastCell);
    
    System.out.println(lastCell.getCellNumber());
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinnerOnVertical_XXX_column_thenThereIsWinner() {
    
    makeMoves("X", 6, 9);
    MoveService.makeMove(table, currentPlayer, () -> "3");
    
    boolean thereWinnerOnVertical = LineChecker.isThereWinnerOnVertical(table, lastCell);
    
    assertTrue(thereWinnerOnVertical);
  }
  
  @Test
  public void isThereWinnerOnVertical_XXO_column_thenNOWinner() {
    
    makeMoves("X", 1, 2);
    MoveService.makeMove(table, currentPlayer.getOppositePlayer(), () -> "3");
    
    boolean thereWinnerOnVertical = LineChecker.isThereWinnerOnVertical(table, lastCell);
    
    assertFalse(thereWinnerOnVertical);
  }
  
  @Test
  public void prepareRegexForWinner_playerX_() {
    
    table = Table.of(3);
    lastCell = Cell.of(1, "X");
    
    LineChecker.prepareRegexForWinner(table, lastCell);
    
    String regexForWinner = LineChecker.getRegexForWinner();
    
    assertEquals(regexForWinner, ".*X{3}.*");
  }
  
  @Test
  public void prepareRegexForWinner_playerO_() {
    
    table = Table.of(3);
    lastCell = Cell.of(1, "O");
    
    LineChecker.prepareRegexForWinner(table, lastCell);
    
    String regexForWinner = LineChecker.getRegexForWinner();
    
    assertEquals(regexForWinner, ".*O{3}.*");
  }
  
  private void makeMoves(String playerSign, int... movesPositions) {
    table = Table.of(3);
    Cell cell = Cell.of(1, "X");
    currentPlayer = Player.valueOf(playerSign);
    
    LineChecker.prepareRegexForWinner(table, cell);
    
    for (int movesPosition : movesPositions) {
      MoveService.makeMove(table, currentPlayer, () -> String.valueOf(movesPosition));
      lastCell = Cell.of(movesPosition, "X");
    }
  }
}