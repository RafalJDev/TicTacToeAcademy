package table.move;

import cell.Cell;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import player.Player;
import table.TableArray;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyOccupied;
import table.move.strategy.MoveStrategyOutOfArray;
import table.move.strategy.MoveStrategyPossible;

import static org.testng.Assert.assertEquals;

public class MoveValidatorTest {
  
  private TableArray tableArray;
  private Cell cell;
  
  @BeforeMethod
  public void setUp() {
    tableArray = TableArray.ofSquareTable(3);
  }
  
  @Test
  public void checkMoveAction_typicalSituation_instanceOfMoveStrategyPossible() {
    cell = Cell.of(5, "X");
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(tableArray, cell);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyPossible.class);
  }
  
  @Test
  public void checkMoveAction_moveXIndexOutOfTable_instanceOfMoveStrategyPossible() {
    cell = Cell.of(10, "X");
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(tableArray, cell);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyOutOfArray.class);
  }
  
  //TODO THERE IS NO Y ANYMORE SO DELETE THIS ?
  @Test(enabled = false)
  public void checkMoveAction_moveYIndexOutOfTable_instanceOfMoveStrategyPossible() {
    cell = Cell.of(-1, "X");
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(tableArray, cell);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyOutOfArray.class);
  }
  
  @Test
  public void checkMoveAction_moveTwoTimesToSamePosition_instanceOfMoveStrategyOccupied() {
    cell = Cell.of(9, "X");
    tableArray.ticTacMove(cell, Player.X);
  
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(tableArray, cell);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyOccupied.class);
  }
  
  
}