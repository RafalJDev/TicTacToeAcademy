package service;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;
import table.Table;

import java.util.function.Supplier;

import static org.testng.Assert.*;

public class MoveServiceTest {
  
  Table table;
  Player player;
  Supplier<String> supplier;
  
  @Test
  public void makeMove_typicalSituation_firstMove_thenTrue() {
    
    table = Table.of(6);
    player = Player.X;
    supplier = () -> "1";
    
    Cell cell = MoveService.makeMove(table, player, supplier);
    
    assertNotNull(cell);
  }
  
  //TODO TestNG timeout doesn't work, so I do some magic
  volatile Cell returnedCell = null;
  
  @Test()
  public void makeMove_typicalSituation_twoMoves_thenMoveDidntHappened() throws InterruptedException {
    table = Table.of(6);
    player = Player.X;
    supplier = () -> "1";
    
    Thread input = new Thread(() -> {
      MoveService.makeMove(table, player, supplier);
      returnedCell = MoveService.makeMove(table, player, supplier);
      
      fail("STUPID! You can't return any value! STUPID!");
    });
    input.start();
    
    input.join(300);
    
    assertNull(returnedCell);
  }
}