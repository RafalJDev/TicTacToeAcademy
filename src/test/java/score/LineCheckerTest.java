package score;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;
import service.MoveService;
import table.Table;
import user.io.entity.IOEntity;
import user.output.printer.TablePrinter;

import static org.testng.Assert.*;

public class LineCheckerTest {
  
  Table table;
  Player currentPlayer;
  Cell lastCell;
  
  @Test()
  public void isThereWinningLine_twoXMovesOnHorizontal_thenNoWinner(/*boolean result, String playerSign, int...movePositions*/) {
    
    makeMoves("X", 1, 2);
    
    boolean isThereWinningRow = LineChecker.isThereWinningLine(table, lastCell);
    
    assertEquals(isThereWinningRow, false);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnHorizontal_thenThereIsWinner() {
    
    makeMoves("X", 1, 2, 3);
    TablePrinter.printTable(table, IOEntity.of(null, System.out::println));
    
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
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnDiagonalRight_thenThereIsWinner() {
    
    makeMoves("X", 7, 5, 3);
    
    boolean isThereWinningRow = LineChecker.isThereWinningLine(table, lastCell);
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinnerOnVertical_XXX_column_thenThereIsWinner() {
    
    makeMoves("X", 6, 9);
    MoveService.makeMove(table, currentPlayer, IOEntity.of(() -> "3", null));
    
    boolean thereWinnerOnVertical = LineChecker.isThereWinnerOnVertical(table, lastCell);
    
    assertTrue(thereWinnerOnVertical);
  }
  
  @Test
  public void isThereWinnerOnVertical_XXO_column_thenNOWinner() {
    
    makeMoves("X", 1, 2);
    MoveService.makeMove(table, currentPlayer.getOppositePlayer(), IOEntity.of(() -> "3", null));
    
    boolean thereWinnerOnVertical = LineChecker.isThereWinnerOnVertical(table, lastCell);
    
    assertFalse(thereWinnerOnVertical);
  }
  
  @Test
  public void prepareRegexForWinner_playerX_() {
  
    table = Table.ofSquareTable(3);
    lastCell = Cell.of(1, "X");
  
    LineChecker.prepareChecker(table, lastCell);
    
    String regexForWinner = LineChecker.getRegexForWinner();
    
    assertEquals(regexForWinner, ".*X{3}.*");
  }
  
  @Test
  public void prepareRegexForWinner_playerO_() {
  
    table = Table.ofSquareTable(3);
    lastCell = Cell.of(1, "O");
  
    LineChecker.prepareChecker(table, lastCell);
    
    String regexForWinner = LineChecker.getRegexForWinner();
    
    assertEquals(regexForWinner, ".*O{3}.*");
  }
  
  private void makeMoves(String playerSign, int... movesPositions) {
    table = Table.ofSquareTable(3);
    Cell cell = Cell.of(1, playerSign);
    currentPlayer = Player.valueOf(playerSign);
  
    LineChecker.prepareChecker(table, cell);
    
    for (int movesPosition : movesPositions) {
      MoveService.makeMove(table, currentPlayer, IOEntity.of(() -> String.valueOf(movesPosition), null));
      lastCell = Cell.of(movesPosition, playerSign);
    }
  }
}