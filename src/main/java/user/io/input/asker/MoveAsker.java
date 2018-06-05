package user.io.input.asker;

import cell.Cell;
import player.Player;
import user.io.output.message.Messages;
import user.io.wrapper.IOEntity;

public class MoveAsker extends Asker {
  
  public MoveAsker(IOEntity localIO) {
    super(localIO);
  }
  
  public Cell askForCoordinates(Player nextPlayer) {
    localIO.acceptOutput(Messages.NEXT_PLAYER_IS + " " + nextPlayer.getPlayerName());
  
    localIO.acceptOutput(Messages.PLEASE_GIVE_COORDINATES.toString());
    localIO.acceptOutput(Messages.ASK_FOR_POSITION.toString());
    
    int position = readLineToInt();
    
    return Cell.of(position, "X");
  }
}
