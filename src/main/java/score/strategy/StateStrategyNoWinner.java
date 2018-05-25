package score.strategy;

import cell.Cell;
import user.io.wrapper.IOEntity;

public class StateStrategyNoWinner extends StateStrategy {
  
  public StateStrategyNoWinner(Cell currentCell) {
    super(currentCell);
  }
  
  @Override
  public boolean stillPlaying(IOEntity ioEntity) {
    return true;
  }
}