package user.input.asker;

import cell.Cell;
import player.Player;
import user.input.InputReader;
import user.io.entity.IOEntity;
import user.output.message.MessagePrinter;

public class MoveAsker {
  
  private final IOEntity ioEntity;
  
  public MoveAsker(IOEntity ioEntity) {
    this.ioEntity = ioEntity;
  }
  
  public Cell askForCoordinates(Player nextPlayer) {
    MessagePrinter.printWhoIsNextPlayer(nextPlayer);
    MessagePrinter.askForPosition();
    int position = readLineToInt();
    
    return Cell.of(position, "X");
  }
  
  private int readLineToInt() {
    String s = InputReader.readLine(ioEntity);
    return Integer.parseInt(s);
  }
}
