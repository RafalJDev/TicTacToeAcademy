package table.move.strategy;

import player.Player;
import table.Table;

public class MoveStrategyOccupied extends MoveStrategy {
  
  public MoveStrategyOccupied(Table table, Coordinates coordinates) {
    super(table, coordinates);
  }
  
  @Override
  public boolean action(Player nextPlayer) {
    printMessage("STUPID ! This cell are already occupied! ");
    return false;
  }
}
