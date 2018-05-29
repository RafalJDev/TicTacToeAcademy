package service.game;

import cell.Cell;
import player.Player;
import service.ConfigurationService;
import service.JudgeService;
import service.MoveService;
import table.TableArray;
import user.io.wrapper.IOEntity;
import user.output.message.Messages;
import user.output.printer.TablePrinter;

public final class TicTacToe {
  
  private Player nextPlayer = Player.X;
  
  public void letsPlay(IOEntity ioEntity) {
  
    ioEntity.acceptOutput(Messages.WELCOME);
    
    boolean stillPlaying = true;
  
    TableArray tableArray = ConfigurationService.configureGame(ioEntity);
    
    while (stillPlaying) {
  
      Cell cell = MoveService.makeMove(tableArray, nextPlayer, ioEntity);
  
      TablePrinter.printTable(tableArray, ioEntity);
      
      stillPlaying =
          JudgeService.checkGameState(tableArray, cell, ioEntity);
  
      nextPlayer = nextPlayer.getOppositePlayer();
    }
    ioEntity.acceptOutput(Messages.FAREWELL);
  }
}