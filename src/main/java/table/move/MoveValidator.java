package table.move;

import table.Table;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyOccupied;
import table.move.strategy.MoveStrategyOutOfArray;
import table.move.strategy.MoveStrategyPossible;

public class MoveValidator {
  
  public static MoveStrategy checkMoveAction(Table table, Coordinates coordinates) {
    
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    
    int gameTableSize = table.getGameTableSize();
    if (xPosition >= gameTableSize || yPosition >= gameTableSize) {
      return new MoveStrategyOutOfArray(table, coordinates);
    } else if (!(table.getSignAt(coordinates).matches("\\d+"))) {
      return new MoveStrategyOccupied(table, coordinates);
    }
    return new MoveStrategyPossible(table, coordinates);
  }
}
