package service;

import player.Player;
import table.Table;
import table.move.MoveValidator;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyPossible;
import user.input.asker.MoveAsker;

import java.util.Scanner;
import java.util.function.Supplier;

public class MoveService {
  
  public static boolean makeMove(Table table, Player currentPlayer, Supplier<String> supplier) {
    if (supplier == null) {
      supplier = new Scanner(System.in)::nextLine;
    }
    
    MoveAsker moveAsker = new MoveAsker(supplier);
    
    MoveStrategy moveStrategy;
    
    do {
      Coordinates coordinates = moveAsker.askForCoordinates(currentPlayer);
      
      moveStrategy = MoveValidator.checkMoveAction(table, coordinates);
  
      moveStrategy.action(currentPlayer);
      
    } while (isMoveHappened(moveStrategy));
    return true;
  }
  
  private static boolean isMoveHappened(MoveStrategy moveStrategy) {
    return !(moveStrategy instanceof MoveStrategyPossible);
  }
}