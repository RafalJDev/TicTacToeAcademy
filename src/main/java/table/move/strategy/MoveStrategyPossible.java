package table.move.strategy;

import cell.Cell;
import player.Player;
import table.TableArray;
import user.io.wrapper.IOEntity;

public class MoveStrategyPossible extends MoveStrategy {
  
  public MoveStrategyPossible(TableArray tableArray, Cell cell) {
    super(tableArray, cell);
  }
  
  @Override
  public void action(Player nextPlayer, IOEntity ioEntity) {
    tableArray.ticTacMove(cell, nextPlayer);
  }
}
