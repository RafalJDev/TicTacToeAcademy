package player;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerTest {
  
  @Test
  public void getOppositePlayer_createOPlayerInvokeMethod_expectXPlayer() {
    Player playerO = Player.O;
    
    Player oppositePlayer = playerO.getOppositePlayer();
    
    String name = oppositePlayer.name();
    
    Assert.assertEquals(name, "X");
  }
}
//_|O|O|0
//-------
//O|O|O
//-----
//O|O|O