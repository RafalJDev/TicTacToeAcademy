package service;

import org.testng.annotations.Test;
import player.Player;
import table.Table;

import java.util.function.Supplier;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class MoveServiceTest {
  
  Table table;
  Player player;
  Supplier<String> supplier;
  
  @Test
  public void makeMove_typicalSituation_firstMove_thenTrue() {
    
    table = Table.of(6, ' ');
    player = Player.X;
    supplier = () -> "1";
    
    boolean isMoveHappend = MoveService.makeMove(table, player, supplier);
    
    assertTrue(isMoveHappend);
  }
  
  //TODO TestNG timeout doesn't work, so I made some magic
  volatile boolean isMoveHappened = false;
  
  @Test
  public void makeMove_typicalSituation_twoMoves_thenTimeOut() throws InterruptedException {
    
    table = Table.of(6, ' ');
    player = Player.X;
    supplier = () -> "1";
    
    Thread input = new Thread(() -> {
      MoveService.makeMove(table, player, supplier);
      isMoveHappened = MoveService.makeMove(table, player, supplier);
      
      fail("STUPID! You can't return any value! STUPID!");
    });
    input.start();
    
    input.join(300);
    
    assertFalse(isMoveHappened);
  }
}