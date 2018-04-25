package game;

import coordinates.Coordinates;
import user.input.InputReader;
import user.output.message.MessagePrinter;
import user.output.message.Messages;
import player.Player;
import table.Table;

import java.util.Scanner;
import java.util.function.Supplier;

public class TicTacToe {
  
  Player nextPlayer = Player.X;
  final Scanner scanner = new Scanner(System.in);
  final Supplier<String> supplier = () -> scanner.nextLine();
  
  public void letsPlay() {
    
    MessagePrinter.printMessage(Messages.WELCOME);
    int tableSizeFromUser = readLineToInt();
  
    boolean andTheWinnerIs = false;
  
    MessagePrinter.printMessage("How big table you wish to play on ?");
    Table table = Table.of(tableSizeFromUser);
  
    while (!andTheWinnerIs) {
      
      MessagePrinter.printWhoIsNextPlayer(nextPlayer);
      MessagePrinter.askForCoordinatesOnX();
      int xPosition = readLineToInt();
      
      MessagePrinter.askForCoordinatesOnY();
      int yPosition = readLineToInt();
    
      Coordinates coordinates = Coordinates.of(xPosition, yPosition);
    
      table.ticTacMove(coordinates, nextPlayer.toChar());
    
      nextPlayer = nextPlayer.getOppositePlayer();
    }
  
    MessagePrinter.printMessage(Messages.FAREWELL);
  }
  
  public int readLineToInt() {
    return InputReader.readLine(supplier);
  }
  
}
