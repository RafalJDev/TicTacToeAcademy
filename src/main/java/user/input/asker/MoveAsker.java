package user.input.asker;

import coordinates.Coordinates;
import player.Player;
import user.input.InputReader;
import user.output.message.MessagePrinter;

import java.util.function.Supplier;

public class MoveAsker {
  
  private final Supplier<String> supplier;
  
  public MoveAsker(Supplier<String> supplier) {
    this.supplier = supplier;
  }
  
  public Coordinates askForCoordinates(Player nextPlayer) {
    MessagePrinter.printWhoIsNextPlayer(nextPlayer);
    MessagePrinter.askForCoordinatesOnX();
    int xPosition = readLineToInt();
    
    MessagePrinter.askForCoordinatesOnY();
    int yPosition = readLineToInt();
    
    return Coordinates.of(xPosition, yPosition);
  }
  
  private int readLineToInt() {
    String s = InputReader.readLine(supplier);
    return Integer.parseInt(s);
  }
}
