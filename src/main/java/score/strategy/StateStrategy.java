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
  
  public abstract boolean stillPlaying(IOEntity ioEntity);
  
  protected boolean yesOrNo(IOEntity ioEntity) {
    while (true) {
      String input = ioEntity.getInput();
      if (input.equals("Y")) {
        return true;
      } else if (input.equals("N")) {
        return false;
      }
      ioEntity.acceptOutput("Please enter [Y]es or [N]o");
    }
  }
}
