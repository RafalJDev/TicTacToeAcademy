package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;
import user.output.message.MessagePrinter;

public abstract class MoveStrategy {
  
  protected Table table;
  protected Cell cell;
  
  public MoveStrategy(Table table, Cell cell) {
    this.table = table;
    this.cell = cell;
  }
  
  abstract public boolean action(Player nextPlayer);
  
  protected void printMessage(String message) {
    MessagePrinter.printMessage(message);
  }
}
