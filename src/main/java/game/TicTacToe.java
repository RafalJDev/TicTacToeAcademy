package game;

import input.InputReader;
import output.message.MessagePrinter;
import output.message.Messages;
import player.Player;

public class TicTacToe {
  
  Player nextPlayer = Player.X;
  
  public void letsPlay() {
    
    MessagePrinter.printMessage(Messages.WELCOME);
    
    boolean endOfTheGame = false;
    while (!endOfTheGame) {
      
      MessagePrinter.printWhoIsNextPlayer(nextPlayer);
      MessagePrinter.askForCoordinatesOnX();
      String xPosition = InputReader.readLine();
      
      MessagePrinter.askForCoordinatesOnY();
      String yPosition = InputReader.readLine();
    }
    
    MessagePrinter.printMessage(Messages.FAREWALL);
  }
}
