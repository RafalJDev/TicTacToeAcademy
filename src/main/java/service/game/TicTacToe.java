package service.game;

import cell.Cell;
import player.Player;
import service.JudgeService;
import service.MoveService;
import table.Table;
import table.TableSize;
import user.input.InputReader;
import user.io.entity.IOEntity;
import user.output.message.MessagePrinter;
import user.output.message.Messages;
import user.output.printer.TablePrinter;

public final class TicTacToe {
  
  private Player nextPlayer = Player.X;
  
  public void letsPlay(IOEntity ioEntity) {
    
    MessagePrinter.printMessage(Messages.WELCOME);
    
    boolean stillPlaying = true;
    
    Table table =
        
        askUserForTable(ioEntity);
    
    while (stillPlaying) {
  
      Cell cell = MoveService.makeMove(table, nextPlayer, ioEntity);
  
      TablePrinter.printTable(table, ioEntity);
      
      stillPlaying =
          JudgeService.checkGameState(table, cell, ioEntity);
  
      nextPlayer = nextPlayer.getOppositePlayer();
    }
    MessagePrinter.printMessage(Messages.FAREWELL);
  }
  
  private Table askUserForTable(IOEntity ioEntity) {
    ioEntity.acceptOutput("How big table you wish to play on ?");
    final int tableSizeFromUser = readLineToInt(ioEntity);
    
    TableSize tableSize;
    
    return Table.ofSquareTable(tableSizeFromUser);
  }
  
  public int readLineToInt(IOEntity ioEntity) {
    String s = InputReader.readLine(ioEntity);
    return Integer.parseInt(s);
  }
  
}