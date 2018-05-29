package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;
import user.io.wrapper.IOEntity;

public class MoveStrategyPossible extends MoveStrategy {
  
  public MoveStrategyPossible(Table table, Cell cell) {
    super(table, cell);
  }
  
  @Override
  public void action(Player nextPlayer, IOEntity ioEntity) {
    String playerToString = nextPlayer.toString();
    table.ticTacMove(cell, playerToString);
  }
}
