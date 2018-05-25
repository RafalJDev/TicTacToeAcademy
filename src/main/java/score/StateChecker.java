package score;

import cell.Cell;
import score.strategy.StateStrategy;
import score.strategy.StateStrategyAndTheWinnerIs;
import score.strategy.StateStrategyDraw;
import score.strategy.StateStrategyNoWinner;
import table.TableArray;

public class StateChecker {
  
  public static StateStrategy moveResult(TableArray tableArray, Cell lastCell) {
    
    StateStrategy stateStrategy = new StateStrategyNoWinner(lastCell);
    
    if (LineChecker.isThereWinningLine(tableArray, lastCell)) {
      stateStrategy = new StateStrategyAndTheWinnerIs(lastCell);
    } else if (tableArray.isTableFilled()) {
      stateStrategy = new StateStrategyDraw(lastCell);
    }
    return stateStrategy;
  }
}
