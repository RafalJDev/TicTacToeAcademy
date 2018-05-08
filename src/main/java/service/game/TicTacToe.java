package service.game;

import cell.Cell;
import player.Player;
import service.JudgeService;
import service.MoveService;
import table.Table;
import user.input.InputReader;
import user.io.entity.IOEntity;
import user.output.message.MessagePrinter;
import user.output.message.Messages;
import user.output.printer.TablePrinter;

import java.util.Scanner;
import java.util.function.Consumer;

public final class TicTacToe {
  
  private final Consumer<StringBuilder> printer = System.out::println;
  private Player nextPlayer = Player.X;
  
  private final IOEntity ioEntity = IOEntity.of(new Scanner(System.in)::nextLine, System.out::println);
  
  public void letsPlay() {
    
    MessagePrinter.printMessage(Messages.WELCOME);
    
    boolean dearUserOfThisVeryComplicatedGameDoYouWannaPlayThisGame = false;
    
    MessagePrinter.printMessage("How big table you wish to play on ?");
    final int tableSizeFromUser = readLineToInt();
    Table table = Table.of(tableSizeFromUser);
    
    while (dearUserOfThisVeryComplicatedGameDoYouWannaPlayThisGame) {
      
      Cell cell = MoveService.makeMove(table, nextPlayer, ioEntity.getSupplier());
      
      TablePrinter.printTable(table, printer);
      
      dearUserOfThisVeryComplicatedGameDoYouWannaPlayThisGame =
          JudgeService.checkGameState(table, cell, ioEntity);
      
      /*nextPlayer = */
      nextPlayer.getOppositePlayer();
    }
    
    MessagePrinter.printMessage(Messages.FAREWELL);
  }
  
  public int readLineToInt() {
    String s = InputReader.readLine(ioEntity.getSupplier());
    return Integer.parseInt(s);
  }
  
}