package score.strategy;

import cell.Cell;
import table.Table;
import user.io.entity.IOEntity;

import java.util.function.Consumer;

public class StateStrategyAndTheWinnerIs extends StateStrategy {
  
  public StateStrategyAndTheWinnerIs(Table table, Cell currentCell) {
    super(table, currentCell);
  }
  
  @Override
  public boolean isThisEndOfTheGame(IOEntity ioEntity) {
    
    Consumer consumer = ioEntity.getConsumer();
    consumer.accept("Congratulations: " +
                        currentCell.sign +
                        " You win the game !" +
                        "Would you like to play again ?");
    
    return true;
  }
}
