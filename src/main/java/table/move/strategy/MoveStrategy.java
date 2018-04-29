package table.move.strategy;

import player.Player;
import table.Table;
import user.output.message.MessagePrinter;

public abstract class MoveStrategy {
  
  protected Table table;
  protected Coordinates coordinates;
  
  public MoveStrategy(Table table, Coordinates coordinates) {
    this.table = table;
    this.coordinates = coordinates;
  }
  
  abstract public boolean action(Player nextPlayer);
  
  protected void printMessage(String message) {
    MessagePrinter.printMessage(message);
  }
}
