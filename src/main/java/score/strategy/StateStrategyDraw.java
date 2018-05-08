package score.strategy;

import cell.Cell;
import table.Table;
import user.io.entity.IOEntity;

public class StateStrategyDraw extends StateStrategy {
  public StateStrategyDraw(Table table, Cell currentCell) {
    super(table, currentCell);
  }
  
  @Override
  public boolean action(IOEntity ioEntity) {
    return false;
  }
}
