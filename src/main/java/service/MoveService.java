package service;

import cell.Cell;
import player.Player;
import table.TableArray;
import table.move.MoveValidator;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyPossible;
import user.input.asker.MoveAsker;
import user.io.wrapper.IOEntity;

public class MoveService {
  
  public static Cell makeMove(TableArray tableArray, Player currentPlayer, IOEntity ioEntity) {
    
    MoveAsker moveAsker = new MoveAsker(ioEntity);
    
    MoveStrategy moveStrategy;
    Cell cell;
    do {
      cell = moveAsker.askForCoordinates(currentPlayer);
  
      moveStrategy = MoveValidator.checkMoveAction(tableArray, cell);
  
      moveStrategy.action(currentPlayer, ioEntity);
      
    } while (isMoveHappened(moveStrategy));
    return cell;
  }
  
  private static boolean isMoveHappened(MoveStrategy moveStrategy) {
    return !(moveStrategy instanceof MoveStrategyPossible);
  }
}