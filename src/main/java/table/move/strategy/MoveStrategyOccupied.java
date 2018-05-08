package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;

public class MoveStrategyOccupied extends MoveStrategy {
  
  public MoveStrategyOccupied(Table table, Cell cell) {
    super(table, cell);
  }
  
  @Override
  public boolean action(Player nextPlayer) {
    printMessage("STUPID ! This cell are already occupied! ");
    return false;
  }
}
