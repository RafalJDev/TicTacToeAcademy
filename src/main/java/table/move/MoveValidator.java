package table.move;

import cell.Cell;
import table.Table;
import table.move.strategy.MoveStrategy;

public class MoveValidator {
  
  public static MoveStrategy checkMoveAction(Table table, Cell cell) {
  
    MoveStrategy moveStrategy;
  
    if (isOutOfArray(table, cell)) {
      moveStrategy = MoveStrategy.OUT_OF_ARRAY;
    } else if (isCellOccupied(table, cell)) {
      moveStrategy = MoveStrategy.OCCUPIED;
    } else {
      moveStrategy = MoveStrategy.POSSIBLE;
    }
    return moveStrategy;
  }
  
  private static boolean isCellOccupied(Table table, Cell cell) {
    return table
        .getSignAt(cell)
        .matches("\\D+");
  }
  
  private static boolean isOutOfArray(Table table, Cell cell) {
    int xPosition = cell.getXPosition(table.getTableSizeOnX());
    int yPosition = cell.getYPosition(table.getTableSizeOnX());
    
    int gameTableSizeOnX = table.getTableSizeOnX();
    int gameTableSizeOnY = table.getTableSizeOnY();
    
    return xPosition >= gameTableSizeOnX || yPosition >= gameTableSizeOnY;
  }
}
