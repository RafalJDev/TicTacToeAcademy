package table.move.strategy;

import cell.Cell;
import player.Player;
import table.TableArray;

public class MoveStrategyOutOfArray extends MoveStrategy {
  
  public MoveStrategyOutOfArray(TableArray tableArray, Cell cell) {
    super(tableArray, cell);
  }
  
  @Override
  public void action(Player nextPlayer) {
    printMessage("Hmm, let's think .. Who would be that idiot, to make a move out ofSquareTable tableArray... You!");
  }
}