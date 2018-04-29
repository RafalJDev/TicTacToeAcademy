package game;

import player.Player;
import service.MoveService;
import table.Table;
import user.input.InputReader;
import user.output.message.MessagePrinter;
import user.output.message.Messages;
import user.output.printer.TablePrinter;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class TicTacToe {
  
  private Player nextPlayer = Player.X;
  private final Scanner scanner = new Scanner(System.in);
  private final Supplier<String> supplier = scanner::nextLine;
  //TODO Consumer<StringBuilder> is not the best idea
  private final Consumer<StringBuilder> printer = System.out::println;
  
  public void letsPlay() {
    
    MessagePrinter.printMessage(Messages.WELCOME);
  
    boolean andTheWinnerIs = false;
  
    MessagePrinter.printMessage("How big table you wish to play on ?");
    final int tableSizeFromUser = readLineToInt();
    Table table = Table.of(tableSizeFromUser, " ");
  
    while (!andTheWinnerIs) {
    
      MoveService.makeMove(table, nextPlayer, supplier);
      
      TablePrinter.printTable(table, printer);
      
      nextPlayer = nextPlayer.getOppositePlayer();
    }
  
    MessagePrinter.printMessage(Messages.FAREWELL);
  }
  
  public int readLineToInt() {
    String s = InputReader.readLine(supplier);
    return Integer.parseInt(s);
  }
  
}