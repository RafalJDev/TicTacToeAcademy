package service.game;

import cell.Cell;
import player.Player;
import service.JudgeService;
import service.MoveService;
import table.TableArray;
import table.wrapper.TableSize;
import user.input.InputReader;
import user.io.wrapper.IOEntity;
import user.output.message.MessagePrinter;
import user.output.message.Messages;
import user.output.printer.TablePrinter;

public final class TicTacToe {
  
  private Player nextPlayer = Player.X;
  
  public void letsPlay(IOEntity ioEntity) {
    
    MessagePrinter.printMessage(Messages.WELCOME);
    
    boolean stillPlaying = true;
  
    TableArray tableArray =
        
        askUserForTable(ioEntity);
    
    while (stillPlaying) {
  
      Cell cell = MoveService.makeMove(tableArray, nextPlayer, ioEntity);
  
      TablePrinter.printTable(tableArray, ioEntity);
      
      stillPlaying =
          JudgeService.checkGameState(tableArray, cell, ioEntity);
  
      nextPlayer = nextPlayer.getOppositePlayer();
    }
    MessagePrinter.printMessage(Messages.FAREWELL);
  }
  
  private TableArray askUserForTable(IOEntity ioEntity) {
    ioEntity.acceptOutput("How big table you wish to play on ?");
    final int tableSizeFromUser = readLineToInt(ioEntity);
    
    TableSize tableSize;
    
    return TableArray.ofSquareTable(tableSizeFromUser);
  }
  
  private int readLineToInt(IOEntity ioEntity) {
    String s = InputReader.readLine(ioEntity);
    return Integer.parseInt(s);
  }
  
}