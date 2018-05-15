package score.strategy;

import cell.Cell;
import table.Table;
import user.io.entity.IOEntity;

public class StateStrategyDraw extends StateStrategy {
  public StateStrategyDraw(Table table, Cell currentCell) {
    super(table, currentCell);
  }
  
  @Override
  public boolean stillPlaying(IOEntity ioEntity) {
  
    ioEntity.acceptOutput("Draw! Nobody wins." +
                              "Would you like to play again [Y/N] ?");
  
    return yesOrNo(ioEntity);
  }
}
