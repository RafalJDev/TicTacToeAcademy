package service;

import cell.Cell;
import score.StateChecker;
import score.strategy.StateStrategy;
import table.TableArray;
import user.io.wrapper.IOEntity;

public class JudgeService {
  
  public static boolean checkGameState(TableArray tableArray, Cell cell, IOEntity ioEntity) {
    
    StateStrategy stateStrategy = StateChecker.moveResult(tableArray, cell);
  
    boolean stillPlaying = stateStrategy.stillPlaying(ioEntity);
  
    return stillPlaying;
  }
}
