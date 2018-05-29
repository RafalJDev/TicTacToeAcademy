package table.move.strategy;

import cell.Cell;
import player.Player;
import table.TableArray;
import user.io.wrapper.IOEntity;

public class MoveStrategyOccupied extends MoveStrategy {
  
  public MoveStrategyOccupied(TableArray tableArray, Cell cell) {
    super(tableArray, cell);
  }
  
  @Override
  public void action(Player nextPlayer, IOEntity ioEntity) {
    printMessage("STUPID ! This cell are already occupied! ", ioEntity);
  }
}
