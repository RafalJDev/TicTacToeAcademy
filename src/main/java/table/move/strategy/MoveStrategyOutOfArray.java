package table.move.strategy;

import player.Player;
import table.Table;

public class MoveStrategyOutOfArray extends MoveStrategy {
  
  public MoveStrategyOutOfArray(Table table, Coordinates coordinates) {
    super(table, coordinates);
  }
  
  @Override
  public boolean action(Player nextPlayer) {
    printMessage("Hmm, let's think .. Who would be that idiot, to make a move out of table... You!");
    return false;
  }
}
