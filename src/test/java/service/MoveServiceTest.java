package service;

import cell.Cell;
import org.testng.annotations.Test;
import player.Player;
import table.TableArray;
import user.io.wrapper.IOEntity;

import java.util.function.Supplier;

import static org.testng.Assert.*;

public class MoveServiceTest {
  
  private TableArray tableArray;
  private Player player;
  private Supplier<String> supplier;
  //TODO TestNG timeout doesn't work, so I do some magic
  private volatile Cell returnedCell = null;
  
  @Test
  public void makeMove_typicalSituation_firstMove_thenTrue() {
  
    tableArray = TableArray.ofSquareTable(6);
    player = Player.X;
    supplier = () -> "1";
  
    Cell cell = MoveService.makeMove(tableArray, player, IOEntity.of(supplier, null));
    
    assertNotNull(cell);
  }
  
  @Test()
  public void makeMove_typicalSituation_twoMoves_thenMoveDidntHappened() throws InterruptedException {
    tableArray = TableArray.ofSquareTable(6);
    player = Player.X;
    supplier = () -> "1";
    
    Thread input = new Thread(() -> {
      MoveService.makeMove(tableArray, player, IOEntity.of(supplier, null));
      returnedCell = MoveService.makeMove(tableArray, player, IOEntity.of(supplier, null));
  
      fail("STUPID! You can't return any value! STUPID!");
    });
    input.start();
  
    input.join(300);
  
    assertNull(returnedCell);
  }
  
  @Test()
  public void makeMove_moveOutOfArray_thenMoveDidntHappened() throws InterruptedException {
    tableArray = TableArray.ofSquareTable(3);
    player = Player.X;
    supplier = () -> "10";
    
    Thread input = new Thread(() -> {
      returnedCell = MoveService.makeMove(tableArray, player, IOEntity.of(supplier, null));
      
      fail("STUPID! You can't return any value! STUPID!");
    });
    input.start();
    
    input.join(300);
    
    assertNull(returnedCell);
  }
}