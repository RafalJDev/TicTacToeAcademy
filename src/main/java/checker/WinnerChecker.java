package checker;

import coordinates.Coordinates;
import player.Player;
import table.Table;

public class WinnerChecker {
  
  private Player currentPlayer;
  
  private Table table;
  
  public void checkIfPlayerWinned(Player player, Table table, Coordinates coordinates) {
    currentPlayer = player;
    this.table = table;
  }
  
  public boolean isWinnerOnVertical(Coordinates coordinates) {
    
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    return false;
  }
}
