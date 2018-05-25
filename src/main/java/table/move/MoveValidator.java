package table.move;

import cell.Cell;
import table.TableArray;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyOccupied;
import table.move.strategy.MoveStrategyOutOfArray;
import table.move.strategy.MoveStrategyPossible;

public class MoveValidator {
  
  public static MoveStrategy checkMoveAction(TableArray tableArray, Cell cell) {
    
    int xPosition = cell.getXPosition(tableArray.getTableSizeOnX());
    int yPosition = cell.getYPosition(tableArray.getTableSizeOnX());
    
    int gameTableSize = tableArray.getTableSizeOnX();
    
    //TODO Question?? Would it be better if I do :moveStrategy= new MoveStrategyPossible(tableArray, cell) here ? instead in else statement?
    MoveStrategy moveStrategy;
    if (xPosition >= gameTableSize || yPosition >= gameTableSize) {
      moveStrategy = new MoveStrategyOutOfArray(tableArray, cell);
    } else if (!(tableArray.getSignAt(cell).matches("\\d+"))) {
      moveStrategy = new MoveStrategyOccupied(tableArray, cell);
    } else {
      moveStrategy = new MoveStrategyPossible(tableArray, cell);
    }
    return moveStrategy;
  }
}
