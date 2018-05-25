package table.move.strategy;

import cell.Cell;
import player.Player;
import table.TableArray;
import user.output.message.MessagePrinter;

public abstract class MoveStrategy {
  
  TableArray tableArray;
  Cell cell;
  
  MoveStrategy(TableArray tableArray, Cell cell) {
    this.tableArray = tableArray;
    this.cell = cell;
  }
  
  public abstract void action(Player nextPlayer);
  
  void printMessage(String message) {
    MessagePrinter.printMessage(message);
  }
}
