package score;

import cell.Cell;
import score.strategy.StateStrategy;
import score.strategy.StateStrategyAndTheWinnerIs;
import score.strategy.StateStrategyDraw;
import score.strategy.StateStrategyNoWinner;
import table.Table;

public class StateChecker {
  
  public static StateStrategy moveResult(Table table, Cell lastCell) {
    
    StateStrategy stateStrategy = new StateStrategyNoWinner(table, lastCell);
    
    if (LineChecker.isThereWinningLine(table, lastCell)) {
      stateStrategy = new StateStrategyAndTheWinnerIs(table, lastCell);
    } else if ((table.getFilledCells() >= table.getCountOfSigns())) {
      stateStrategy = new StateStrategyDraw(table, lastCell);
    }
    return stateStrategy;
  }
}
