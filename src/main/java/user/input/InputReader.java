package user.input;

import user.input.valid.strategy.ValidStrategy;
import user.input.valid.strategy.ValidStrategyNumber;
import user.io.entity.IOEntity;

import java.util.function.Supplier;

public class InputReader {
  
  public static String readLine(IOEntity ioEntity) {
    
    String nextLine;
    ValidStrategy validStrategyState = null;
    do {
      nextLine = ioEntity.getInput();
      validStrategyState = InputValidator.checkInput(nextLine);
      
    } while (isNotValid(validStrategyState));
    
    return nextLine;
  }
  
  public static boolean isNotValid(ValidStrategy validStrategyState) {
    return validStrategyState.getClass() != ValidStrategyNumber.class;
  }
  
}
