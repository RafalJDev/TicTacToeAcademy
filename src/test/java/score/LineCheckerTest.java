package score;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;
import service.MoveService;
import table.TableArray;
import user.io.wrapper.IOEntity;
import user.output.printer.TablePrinter;

import static org.testng.Assert.*;

public class LineCheckerTest {
  
  private TableArray tableArray;
  private Player currentPlayer;
  private Cell lastCell;
  
  @Test()
  public void isThereWinningLine_twoXMovesOnHorizontal_thenNoWinner(/*boolean result, String playerSign, int...movePositions*/) {
    
    makeMoves("X", 1, 2);
  
    boolean isThereWinningRow = LineChecker.isThereWinningLine(tableArray, lastCell);
  
    assertFalse(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnHorizontal_thenThereIsWinner() {
    
    makeMoves("X", 1, 2, 3);
    TablePrinter.printTable(tableArray, IOEntity.of(null, System.out::println));
  
    boolean isThereWinningRow = LineChecker.isThereWinningLine(tableArray, lastCell);
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_twoXMovesOnVertical_thenNoWinner() {
    
    makeMoves("X", 5, 2);
  
    boolean isThereWinningRow = LineChecker.isThereWinningLine(tableArray, lastCell);
    
    assertFalse(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnVertical_thenThereIsWinner() {
    
    makeMoves("X", 5, 2, 8);
  
    boolean isThereWinningRow = LineChecker.isThereWinningLine(tableArray, lastCell);
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinningLine_threeXMovesOnDiagonalRight_thenThereIsWinner() {
    
    makeMoves("X", 7, 5, 3);
  
    boolean isThereWinningRow = LineChecker.isThereWinningLine(tableArray, lastCell);
    
    assertTrue(isThereWinningRow);
  }
  
  @Test
  public void isThereWinnerOnVertical_XXX_column_thenThereIsWinner() {
    
    makeMoves("X", 6, 9);
    MoveService.makeMove(tableArray, currentPlayer, IOEntity.of(() -> "3", null));
  
    boolean thereWinnerOnVertical = LineChecker.isThereWinnerOnVertical(lastCell);
    
    assertTrue(thereWinnerOnVertical);
  }
  
  @Test
  public void isThereWinnerOnVertical_XXO_column_thenNOWinner() {
    
    makeMoves("X", 1, 2);
    MoveService.makeMove(tableArray, currentPlayer.getOppositePlayer(), IOEntity.of(() -> "3", null));
  
    boolean thereWinnerOnVertical = LineChecker.isThereWinnerOnVertical(lastCell);
    
    assertFalse(thereWinnerOnVertical);
  }
  
  @Test
  public void prepareRegexForWinner_playerX_() {
  
    tableArray = TableArray.ofSquareTable(3);
    lastCell = Cell.of(1, "X");
  
    LineChecker.prepareChecker(tableArray, lastCell);
    
    String regexForWinner = LineChecker.getRegexForWinner();
    
    assertEquals(regexForWinner, ".*X{3}.*");
  }
  
  @Test
  public void prepareRegexForWinner_playerO_() {
  
    tableArray = TableArray.ofSquareTable(3);
    lastCell = Cell.of(1, "O");
  
    LineChecker.prepareChecker(tableArray, lastCell);
    
    String regexForWinner = LineChecker.getRegexForWinner();
    
    assertEquals(regexForWinner, ".*O{3}.*");
  }
  
  private void makeMoves(String playerSign, int... movesPositions) {
    tableArray = TableArray.ofSquareTable(3);
    Cell cell = Cell.of(1, playerSign);
    currentPlayer = Player.valueOf(playerSign);
  
    LineChecker.prepareChecker(tableArray, cell);
    
    for (int movesPosition : movesPositions) {
      MoveService.makeMove(tableArray, currentPlayer, IOEntity.of(() -> String.valueOf(movesPosition), null));
      lastCell = Cell.of(movesPosition, playerSign);
    }
  }
}