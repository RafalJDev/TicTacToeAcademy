package score.strategy;

import cell.Cell;
import user.io.wrapper.IOEntity;

public class StateStrategyAndTheWinnerIs extends StateStrategy {
  
  public StateStrategyAndTheWinnerIs(Cell currentCell) {
    super(currentCell);
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
