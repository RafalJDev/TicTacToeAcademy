package score.strategy;

import cell.Cell;
import table.Table;
import user.io.entity.IOEntity;

public class StateStrategyAndTheWinnerIs extends StateStrategy {
  
  public StateStrategyAndTheWinnerIs(Table table, Cell currentCell) {
    super(table, currentCell);
  }
  
  @Override
  public boolean stillPlaying(IOEntity ioEntity) {
  
    ioEntity.acceptOutput("Congratulations: " +
                              currentCell.sign +
                              " You win the game !" +
                              "Would you like to play again [Y/N] ?");
  
    return yesOrNo(ioEntity);
  }
}
