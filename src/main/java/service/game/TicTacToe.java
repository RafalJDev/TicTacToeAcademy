package service.game;

import cell.Cell;
import player.Player;
import service.ConfigurationService;
import service.JudgeService;
import service.MoveService;
import table.Table;
import user.io.wrapper.IOEntity;
import user.output.message.Messages;
import user.output.printer.TablePrinter;

public final class TicTacToe {
  
  private Player nextPlayer = Player.X;
  
  public void letsPlay(IOEntity ioEntity) {
  
    ioEntity.acceptOutput(Messages.WELCOME);
    
    boolean stillPlaying = true;
  
    Table table = ConfigurationService.configureGame(ioEntity);
    
    while (stillPlaying) {
  
      Cell cell = MoveService.makeMove(table, nextPlayer, ioEntity);
  
      TablePrinter.printTable(table, ioEntity);
      
      stillPlaying =
          JudgeService.checkGameState(table, cell, ioEntity);
  
      nextPlayer = nextPlayer.getOppositePlayer();
    }
    ioEntity.acceptOutput(Messages.FAREWELL);
  }
}