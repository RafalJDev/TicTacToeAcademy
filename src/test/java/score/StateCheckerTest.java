package score;

import cell.Cell;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import player.Player;
import score.strategy.StateStrategy;
import score.strategy.StateStrategyAndTheWinnerIs;
import score.strategy.StateStrategyDraw;
import score.strategy.StateStrategyNoWinner;
import service.MoveService;
import table.Table;
import user.io.wrapper.IOEntity;

import static org.testng.Assert.assertTrue;

public class StateCheckerTest {
  
  private Table table;
  private Cell lastCell;
  private Player currentPlayer;
  
  @BeforeMethod
  public void setUp() {
    table = Table.ofSquareTable(3);
  }
  
  @Test
  public void moveResult_firstMove_thenFalse() {
  
    table = Table.ofSquareTable(3);
    currentPlayer = Player.X;
    lastCell = Cell.of(5, currentPlayer.toString());
  
    StateStrategy stateStrategy = StateChecker.moveResult(table, lastCell);
    
    assertTrue(stateStrategy instanceof StateStrategyNoWinner);
  }
  
  @Test
  public void moveResult_someMovesWithWinningLineOnHorizontalWithO_thenThereIsWinner() {
  
    table = Table.ofSquareTable(3);
    currentPlayer = Player.X;
    lastCell = Cell.of(5, currentPlayer.toString());
    makeMoves(currentPlayer.toString(), 1, 3, 7, 9);
    makeMoves(currentPlayer.getOppositePlayer().toString(), 2, 4, 5, 8, 6);
  
    StateStrategy stateStrategy = StateChecker.moveResult(table, lastCell);
    
    assertTrue(stateStrategy instanceof StateStrategyAndTheWinnerIs);
  }
  
  @Test
  public void moveResult_someMovesToDraw_thenDraw() {
  
    table = Table.ofSquareTable(3);
    currentPlayer = Player.X;
    lastCell = Cell.of(5, currentPlayer.toString());
    makeMoves(currentPlayer.toString(), 1, 3, 5, 6, 7);
    makeMoves(currentPlayer.getOppositePlayer().toString(), 2, 4, 8, 9);
  
    StateStrategy stateStrategy = StateChecker.moveResult(table, lastCell);
    
    assertTrue(stateStrategy instanceof StateStrategyDraw);
  }
  
  private void makeMoves(String playerSign, int... movesPositions) {
  
    Cell cell = Cell.of(1, playerSign);
    currentPlayer = Player.valueOf(playerSign);
  
    LineChecker.prepareChecker(table, cell);
    
    for (int movesPosition : movesPositions) {
      MoveService.makeMove(table, currentPlayer, IOEntity.of(() -> String.valueOf(movesPosition), s -> {
      }));
      lastCell = Cell.of(movesPosition, playerSign);
    }
  }
}