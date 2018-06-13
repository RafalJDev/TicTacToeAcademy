package service.game;

import cell.Cell;
import player.Player;
import service.ConfigurationService;
import service.JudgeService;
import service.MoveService;
import table.Table;
import user.io.output.message.Messages;
import user.io.output.printer.TablePrinter;
import user.io.wrapper.IOEntity;

public final class TicTacToe {
  
  private Player nextPlayer = Player.X;
  
  public void letsPlay(IOEntity ioEntity) {
  
    ioEntity.acceptOutput(Messages.WELCOME);
    
    boolean stillPlaying = true;
  
    ConfigurationService configurationService = new ConfigurationService(ioEntity);
  
    Table table = configurationService.configureTable();
  
    Player nextPlayer = configurationService.configurePlayerName();
    
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