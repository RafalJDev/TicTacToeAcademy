package checker;

import player.Player;
import table.Table;

public class WinnerChecker {
  
  private Player currentPlayer;
  
  private Table table;
  
  public void checkIfPlayerWinned(Player player, Table table) {
    currentPlayer = player;
    this.table = table;
  }
  
  public boolean isWinnerOnVertical() {
  
    boolean t;
    boolean t2;
    return false;
  }
}
