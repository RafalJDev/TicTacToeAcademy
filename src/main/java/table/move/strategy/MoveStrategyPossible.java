package table.move.strategy;

import cell.Cell;
import player.Player;
import table.TableArray;

public class MoveStrategyPossible extends MoveStrategy {
  
  public MoveStrategyPossible(TableArray tableArray, Cell cell) {
    super(tableArray, cell);
  }
  
  @Override
  public void action(Player nextPlayer) {
    tableArray.ticTacMove(cell, nextPlayer);
  }
}
