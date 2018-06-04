package service;

import cell.Cell;
import player.Player;
import table.Table;
import table.move.MoveValidator;
import table.move.strategy.MoveStrategy;
import user.input.asker.MoveAsker;
import user.io.wrapper.IOEntity;

public class MoveService {
  
  public static Cell makeMove(Table table, Player currentPlayer, IOEntity ioEntity) {
    
    MoveAsker moveAsker = new MoveAsker(ioEntity);
    
    MoveStrategy moveStrategy;
    Cell cell;
    do {
      cell = moveAsker.askForCoordinates(currentPlayer);
  
      moveStrategy = MoveValidator.checkMoveAction(table, cell);
  
      moveStrategy.action(table, currentPlayer, cell, ioEntity);
      
    } while (isMoveHappened(moveStrategy));
    return cell;
  }
  
  private static boolean isMoveHappened(MoveStrategy moveStrategy) {
    MoveStrategy possible = MoveStrategy.POSSIBLE;
    return !(moveStrategy.getClass().equals(possible.getClass()));
  }
}