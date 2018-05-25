package score.strategy;

import cell.Cell;
import user.io.wrapper.IOEntity;

public abstract class StateStrategy {
  
  Cell currentCell;
  
  StateStrategy(Cell currentCell) {
    this.currentCell = currentCell;
  }
  
  public abstract boolean stillPlaying(IOEntity ioEntity);
  
  boolean yesOrNo(IOEntity ioEntity) {
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