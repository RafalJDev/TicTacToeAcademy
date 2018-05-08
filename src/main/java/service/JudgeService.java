package service;

import cell.Cell;
import score.StateChecker;
import score.strategy.StateStrategy;
import table.Table;
import user.io.entity.IOEntity;

public class JudgeService {
  
  public static boolean checkGameState(Table table, Cell cell, IOEntity ioEntity) {
    
    StateStrategy stateStrategy = StateChecker.isThisEndOfTheGame(table, cell);
    
    stateStrategy.action(ioEntity);
    
    return false;
  }
}
