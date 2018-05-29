package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;
import user.io.wrapper.IOEntity;

public abstract class MoveStrategy {
  
  Table table;
  Cell cell;
  
  MoveStrategy(Table table, Cell cell) {
    this.table = table;
    this.cell = cell;
  }
  
  public abstract void action(Player nextPlayer, IOEntity ioEntity);
  
  void printMessage(String message, IOEntity ioEntity) {
    ioEntity.acceptOutput(message);
  }
}
