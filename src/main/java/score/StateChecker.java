package score;

import cell.Cell;
import score.strategy.StateStrategy;
import score.strategy.StateStrategyAndTheWinnerIs;
import score.strategy.StateStrategyDraw;
import score.strategy.StateStrategyNoWinner;
import table.Table;

public class StateChecker {
  
  public static StateStrategy moveResult(Table table, Cell cell) {
    
    StateStrategy stateStrategy = null;
  
    stateStrategy = new StateStrategyNoWinner(table, cell);
    if (LineChecker.isThereWinningLine(table, cell)) {
      stateStrategy = new StateStrategyAndTheWinnerIs(table, cell);
    } else if ((table.getFilledCells() >= table.getGameTableSize())) {
      //TODO
      stateStrategy = new StateStrategyDraw(table, cell);
    }
    return stateStrategy;
  }
}
