package score.strategy;

import cell.Cell;
import table.Table;
import user.io.entity.IOEntity;

public abstract class StateStrategy {
  
  protected Table table;
  protected Cell currentCell;
  
  public StateStrategy(Table table, Cell currentCell) {
    this.table = table;
    this.currentCell = currentCell;
  }
  
  public abstract boolean action(IOEntity ioEntity);
}
