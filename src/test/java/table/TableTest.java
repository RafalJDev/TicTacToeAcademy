package table;

import coordinates.Coordinates;
import org.testng.annotations.Test;
import player.Player;

import static org.testng.Assert.assertEquals;

public class TableTest {
  
  Table table;
  final char signToFillTableWith = ' ';

  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Table can't be: " + 2)
  public void createNewTable_withIllegalArgument_thenException() {
  
    int toSmallTableSize = 2;
    table = Table.of(toSmallTableSize, signToFillTableWith);
  }
  
  @Test
  public void createNewTable_correctSize() {
  
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
  
    int gameTableSize = table.getGameTableSize();
  
    int expectedSize = 3;
    assertEquals(gameTableSize, expectedSize);
  }
  
  @Test
  public void createNewTable_try() {
    
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
    
  }
  
  @Test
  public void createNewTable_shouldContainUnderscore_inTheMiddle() {
    
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
  
    char signInTheMiddleOfArray = table.getSignAt(1, 1);
  
    assertEquals(signInTheMiddleOfArray, signToFillTableWith);
  }
  
  @Test
  public void ticTacMove_typicalSituation_firstMove_expectXAtPosition() {
    
    int standardSize = 3;
    table = Table.of(standardSize, signToFillTableWith);
    
    final Coordinates coordinates = Coordinates.of(1, 1);
    Player x = Player.X;
    final char xChar = x.toChar();
    
    table.ticTacMove(coordinates, xChar);
    
    char signAt = table.getSignAt(coordinates);
    
    assertEquals(signAt, xChar);
  }
  
}