package table.move.strategy;

import player.Player;
import table.Table;

public class MoveStrategyPossible extends MoveStrategy {
  
  public MoveStrategyPossible(Table table, Coordinates coordinates) {
    super(table, coordinates);
  }
  
  @Override
  public boolean action(Player nextPlayer) {
    table.ticTacMove(coordinates, nextPlayer);
    return true;
  }
}
