package table.move.strategy;

import cell.Cell;
import player.Player;
import table.TableArray;
import user.io.wrapper.IOEntity;

public abstract class MoveStrategy {
  
  TableArray tableArray;
  Cell cell;
  
  MoveStrategy(TableArray tableArray, Cell cell) {
    this.tableArray = tableArray;
    this.cell = cell;
  }
  
  public abstract void action(Player nextPlayer, IOEntity ioEntity);
  
  void printMessage(String message, IOEntity ioEntity) {
    ioEntity.acceptOutput(message);
  }
}
