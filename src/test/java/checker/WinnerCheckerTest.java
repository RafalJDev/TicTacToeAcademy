package checker;

import coordinates.Coordinates;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WinnerCheckerTest {
  
  WinnerChecker winnerChecker;
  
  @BeforeMethod
  public void setUp() {
  }
  
  @Test
  public void isWinnerOnVertical() {
  
    winnerChecker = new WinnerChecker();
  
    Coordinates coordinates = Coordinates.of(2, 2);
    boolean andTheWinnerIs = winnerChecker.isWinnerOnVertical(coordinates);
    
    boolean expectedToWin = false;
    assertEquals(andTheWinnerIs, expectedToWin);
  }
}