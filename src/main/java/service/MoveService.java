package service;

import cell.Cell;
import player.Player;
import table.Table;
import table.move.MoveValidator;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyPossible;
import user.input.asker.MoveAsker;
import user.io.entity.IOEntity;

import java.util.function.Supplier;

public class MoveService {
  
  public static Cell makeMove(Table table, Player currentPlayer, IOEntity ioEntity) {
    
    MoveAsker moveAsker = new MoveAsker(ioEntity);
    
    MoveStrategy moveStrategy;
    Cell cell;
    do {
      cell = moveAsker.askForCoordinates(currentPlayer);
      
      moveStrategy = MoveValidator.checkMoveAction(table, cell);
      
      moveStrategy.action(currentPlayer);
      
    } while (isMoveHappened(moveStrategy));
    return cell;
  }
  
  private static boolean isMoveHappened(MoveStrategy moveStrategy) {
    return !(moveStrategy instanceof MoveStrategyPossible);
  }
}