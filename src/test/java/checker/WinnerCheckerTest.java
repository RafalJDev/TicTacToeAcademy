package checker;

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
    
    boolean andTheWinnerIs = winnerChecker.isWinnerOnVertical();
    
    boolean expectedToWin = false;
    assertEquals(andTheWinnerIs, expectedToWin);
  }
}