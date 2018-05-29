package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;
import user.io.wrapper.IOEntity;

public class MoveStrategyOccupied extends MoveStrategy {
  
  public MoveStrategyOccupied(Table table, Cell cell) {
    super(table, cell);
  }
  
  @Override
  public void action(Player nextPlayer, IOEntity ioEntity) {
    printMessage("STUPID ! This cell are already occupied! ", ioEntity);
  }
}
