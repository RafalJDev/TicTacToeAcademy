package user.input;

import user.input.valid.strategy.ValidStrategy;
import user.input.valid.strategy.ValidStrategyNumber;

import java.util.function.Supplier;

public class InputReader {
  
  public static String readLine(Supplier<String> supplier) {
    
    String nextLine;
    ValidStrategy validStrategyState = null;
    do {
      nextLine = supplier.get();
      validStrategyState = InputValidator.checkInput(nextLine);
  
    } while (isNotValid(validStrategyState));
    
    return nextLine;
  }
  
  public static boolean isNotValid(ValidStrategy validStrategyState) {
    return validStrategyState.getClass() != ValidStrategyNumber.class;
  }
  
}
