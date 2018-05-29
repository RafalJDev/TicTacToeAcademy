package user.input.asker;

import cell.Cell;
import player.Player;
import user.io.wrapper.IOEntity;
import user.output.message.Messages;

public class MoveAsker extends Asker {
  
  public MoveAsker(IOEntity localIO) {
    super(localIO);
  }
  
  public Cell askForCoordinates(Player nextPlayer) {
    localIO.acceptOutput(Messages.NEXT_PLAYER_IS + " " + nextPlayer);
  
    localIO.acceptOutput(Messages.PLEASE_GIVE_COORDINATES.toString());
    localIO.acceptOutput(Messages.ASK_FOR_POSITION.toString());
    
    int position = readLineToInt();
    
    return Cell.of(position, "X");
  }
}
