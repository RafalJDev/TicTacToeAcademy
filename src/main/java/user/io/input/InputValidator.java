package user.io.input;

import user.io.input.validator.strategy.*;

class InputValidator {
  
  public static ValidStrategy checkInput(String userInput) {
  
    ValidStrategy validStrategyState = new ValidStrategyWord(userInput);
    
    if (userInput.matches("\\d+")) {
      validStrategyState = new ValidStrategyNumber(userInput);
    } else if (userInput.isEmpty()) {
      validStrategyState = new ValidStrategyEmpty(userInput); // todo test
    } else if (userInput.startsWith("-")) {
      validStrategyState = new ValidStrategyNegativeNumber(userInput);
    }
  
    return validStrategyState;
  }
  
}
