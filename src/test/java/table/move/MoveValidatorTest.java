package table.move;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import player.Player;
import table.Table;
import table.move.strategy.MoveStrategy;
import table.move.strategy.MoveStrategyOccupied;
import table.move.strategy.MoveStrategyOutOfArray;
import table.move.strategy.MoveStrategyPossible;

import static org.testng.Assert.*;

public class MoveValidatorTest {
  
  Table table;
  Coordinates coordinates;
  
  @BeforeMethod
  public void setUp() {
    table = Table.of(3, " ");
  }
  
  @Test
  public void checkMoveAction_typicalSituation_instanceOfMoveStrategyPossible() {
    coordinates = Coordinates.of(1, 1);
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(table, coordinates);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyPossible.class);
  }
  
  @Test
  public void checkMoveAction_moveXIndexOutOfTable_instanceOfMoveStrategyPossible() {
    coordinates = Coordinates.of(3, 2);
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(table, coordinates);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyOutOfArray.class);
  }
  
  @Test
  public void checkMoveAction_moveYIndexOutOfTable_instanceOfMoveStrategyPossible() {
    coordinates = Coordinates.of(2, 3);
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(table, coordinates);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyOutOfArray.class);
  }
  
  @Test
  public void checkMoveAction_moveTwoTimesToSamePosition_instanceOfMoveStrategyOccupied() {
    coordinates = Coordinates.of(2, 2);
    table.ticTacMove(coordinates, Player.X);
    
    MoveStrategy moveStrategy = MoveValidator.checkMoveAction(table, coordinates);
    
    assertEquals(moveStrategy.getClass(), MoveStrategyOccupied.class);
  }
}