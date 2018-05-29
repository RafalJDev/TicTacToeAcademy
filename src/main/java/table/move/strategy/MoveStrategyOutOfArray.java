package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;
import user.io.wrapper.IOEntity;

public class MoveStrategyOutOfArray extends MoveStrategy {
  
  public MoveStrategyOutOfArray(Table table, Cell cell) {
    super(table, cell);
  }
  
  @Override
  public void action(Player nextPlayer, IOEntity ioEntity) {
    printMessage("Hmm, let's think .. Who would be that idiot, to make a move out ofSquareTable table... You!",
                 ioEntity);
  }
}