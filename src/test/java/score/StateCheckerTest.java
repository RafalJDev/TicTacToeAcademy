package score;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;
import score.strategy.StateStrategy;
import score.strategy.StateStrategyNoWinner;
import table.Table;

import static org.testng.Assert.assertTrue;

public class StateCheckerTest {
  
  Table table;
  Cell currentCell;
  Player currentPlayer;
  
  @Test
  public void isThisEndOfTheGame_firstMove_thenFalse() {
    
    table = Table.of(3);
    currentPlayer = Player.X;
    currentCell = Cell.of(5, currentPlayer.toString());
    
    
    StateStrategy stateStrategy = StateChecker.moveResult(table, currentCell);
    
    assertTrue(stateStrategy instanceof StateStrategyNoWinner);
  }
}