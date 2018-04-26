package table;

import coordinates.Coordinates;
import org.testng.annotations.Test;
import player.Player;

import static org.testng.Assert.*;

public class SignValidatorTest {
  
  @Test
  public void isSignAlreadyHere() {
    
    Table table = null;
    Coordinates coordinates = null;
    Player currentPlayer = null;
    
    boolean signAlreadyHere = SignValidator.isSignAlreadyHere(table, coordinates, currentPlayer);
    
    assertFalse(signAlreadyHere);
  }
  
}