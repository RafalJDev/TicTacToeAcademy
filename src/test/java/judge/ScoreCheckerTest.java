package judge;

import coordinates.Coordinates;
import org.testng.annotations.Test;
import player.Player;
import table.Table;

import static org.testng.Assert.*;

public class ScoreCheckerTest {
  
  Table table;
  Coordinates coordinates;
  Player currentPlayer;
  
  @Test
  public void isThisEndOfTheGame_firstMove_thenFalse() {
    
    table = Table.of(3, ' ');
    
    boolean thisEndOfTheGame = ScoreChecker.isThisEndOfTheGame(table, coordinates, currentPlayer);
    
    assertFalse(thisEndOfTheGame);
  }
}