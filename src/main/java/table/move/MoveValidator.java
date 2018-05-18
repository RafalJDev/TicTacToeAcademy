package table.move;

import cell.Cell;
import table.Table;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyOccupied;
import table.move.strategy.MoveStrategyOutOfArray;
import table.move.strategy.MoveStrategyPossible;

public class MoveValidator {
  
  public static MoveStrategy checkMoveAction(Table table, Cell cell) {
  
    int xPosition = cell.getXPosition(table.getTableSizeOnX());
    int yPosition = cell.getYPosition(table.getTableSizeOnX());
  
    int gameTableSize = table.getTableSizeOnX();
    
    //TODO Question?? Would it be better if I do :moveStrategy= new MoveStrategyPossible(table, cell) here ? instead in else statement?
    MoveStrategy moveStrategy;
    if (xPosition >= gameTableSize || yPosition >= gameTableSize) {
      moveStrategy = new MoveStrategyOutOfArray(table, cell);
    } else if (!(table.getSignAt(cell).matches("\\d+"))) {
      moveStrategy = new MoveStrategyOccupied(table, cell);
    } else {
      moveStrategy = new MoveStrategyPossible(table, cell);
    }
    return moveStrategy;
  }
}
