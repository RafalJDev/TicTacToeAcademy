package score;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;
import score.strategy.StateStrategy;
import score.strategy.StateStrategyAndTheWinnerIs;
import score.strategy.StateStrategyDraw;
import score.strategy.StateStrategyNoWinner;
import service.MoveService;
import table.Table;
import user.io.entity.IOEntity;

import static org.testng.Assert.assertTrue;

public class StateCheckerTest {
  
  private Table table;
  private Cell lastCell;
  private Player currentPlayer;
  
  @Test
  public void moveResult_firstMove_thenFalse() {
    
    table = Table.of(3);
    currentPlayer = Player.X;
    lastCell = Cell.of(5, currentPlayer.toString());
  
    StateStrategy stateStrategy = StateChecker.moveResult(table, lastCell);
    
    assertTrue(stateStrategy instanceof StateStrategyNoWinner);
  }
  
  @Test
  public void moveResult_someMovesWithWinningLineOnHorizontalWithO_thenThereIsWinner() {
    
    table = Table.of(3);
    currentPlayer = Player.X;
    lastCell = Cell.of(5, currentPlayer.toString());
    makeMoves(currentPlayer.toString(), 1, 3, 7, 9);
    makeMoves(currentPlayer.toString(), 2, 4, 5, 6, 8);
    
    StateStrategy stateStrategy = StateChecker.moveResult(table, lastCell);
    
    System.out.println(stateStrategy);
    assertTrue(stateStrategy instanceof StateStrategyAndTheWinnerIs);
  }
  
  @Test
  public void moveResult_someMovesToDraw_thenDraw() {
    
    table = Table.of(3);
    currentPlayer = Player.X;
    lastCell = Cell.of(5, currentPlayer.toString());
    makeMoves(currentPlayer.toString(), 1, 3, 5, 6, 7);
    makeMoves(currentPlayer.toString(), 2, 4, 8, 9);
    
    StateStrategy stateStrategy = StateChecker.moveResult(table, lastCell);
    
    System.out.println(stateStrategy);
    assertTrue(stateStrategy instanceof StateStrategyDraw);
  }
  
  private void makeMoves(String playerSign, int... movesPositions) {
    //TODO WET this method is copied from LineCheckerTest, double Table.of to prevent Intellij to highlight it
    table = Table.of(3);
    table = Table.of(3);
    
    Cell cell = Cell.of(1, "X");
    currentPlayer = Player.valueOf(playerSign);
    
    LineChecker.prepareRegexForWinner(table, cell);
    
    for (int movesPosition : movesPositions) {
      MoveService.makeMove(table, currentPlayer, IOEntity.of(() -> String.valueOf(movesPosition), null));
      lastCell = Cell.of(movesPosition, "X");
    }
  }
}