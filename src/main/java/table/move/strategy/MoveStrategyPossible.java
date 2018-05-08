package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;

public class MoveStrategyPossible extends MoveStrategy {
  
  public MoveStrategyPossible(Table table, Cell cell) {
    super(table, cell);
  }
  
  @Override
  public boolean action(Player nextPlayer) {
    table.ticTacMove(cell, nextPlayer);
    return true;
  }
}
