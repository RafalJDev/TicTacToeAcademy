package score.strategy;

import cell.Cell;
import user.io.wrapper.IOEntity;

public class StateStrategyDraw extends StateStrategy {
  
  public StateStrategyDraw(Cell currentCell) {
    super(currentCell);
  }
  
  @Override
  public boolean stillPlaying(IOEntity ioEntity) {
  
    ioEntity.acceptOutput("Draw! Nobody wins." +
                              "Would you like to play again [Y/N] ?");
  
    return yesOrNo(ioEntity);
  }
}
