package table.move.strategy;

import cell.Cell;
import player.Player;
import table.Table;
import user.io.wrapper.IOEntity;

public enum MoveStrategy {
  
  //TODO that enum, was created due to refactoring, but now it don't look to good.
  //TODO so probably revert in not a bad (intellij)idea
  OCCUPIED {
    @Override
    public void action(Table table, Player currentPlayer, Cell cell, IOEntity ioEntity) {
      printMessage("STUPID ! This cell are already occupied! ", ioEntity);
    }
  }, OUT_OF_ARRAY {
    @Override
    public void action(Table table, Player currentPlayer, Cell cell, IOEntity ioEntity) {
      printMessage(
          "Hmm, let's think .. Who would be that idiot," +
              " to make a move out ofSquareTable table... You!",
          ioEntity);
    }
  }, POSSIBLE {
    @Override
    public void action(Table table, Player currentPlayer, Cell cell, IOEntity ioEntity) {
      String playerToString = currentPlayer.toString();
      table.ticTacMove(cell, playerToString);
    }
  };
  
  void printMessage(String message, IOEntity ioEntity) {
    ioEntity.acceptOutput(message);
  }
  
  public abstract void action(Table table, Player currentPlayer, Cell cell, IOEntity ioEntity);
}
