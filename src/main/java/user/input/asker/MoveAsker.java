package user.input.asker;

import cell.Cell;
import player.Player;
import user.input.InputReader;
import user.output.message.MessagePrinter;

import java.util.function.Supplier;

public class MoveAsker {
  
  private final Supplier<String> supplier;
  
  public MoveAsker(Supplier<String> supplier) {
    this.supplier = supplier;
  }
  
  public Cell askForCoordinates(Player nextPlayer) {
    MessagePrinter.printWhoIsNextPlayer(nextPlayer);
    MessagePrinter.askForPosition();
    int position = readLineToInt();
    
    return Cell.of(position, "X");
  }
  
  private int readLineToInt() {
    String s = InputReader.readLine(supplier);
    return Integer.parseInt(s);
  }
}
