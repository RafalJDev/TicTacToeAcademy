package user.io.input;

import user.io.input.validator.strategy.ValidStrategy;
import user.io.input.validator.strategy.ValidStrategyNumber;
import user.io.wrapper.IOEntity;

public class InputReader {
  
  public static String readLine(IOEntity ioEntity) {
    
    String nextLine;
    ValidStrategy validStrategyState;
    do {
      nextLine = ioEntity.getInput();
      validStrategyState = InputValidator.checkInput(nextLine);
      validStrategyState.action(ioEntity);
      
    } while (isNotValid(validStrategyState));
    
    return nextLine;
  }
  
  public static boolean isNotValid(ValidStrategy validStrategyState) {
    return validStrategyState.getClass() != ValidStrategyNumber.class;
  }
  
}
