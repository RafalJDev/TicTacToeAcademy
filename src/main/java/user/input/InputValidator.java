package user.input;

import user.input.valid.NotValidNegativeNumber;
import user.input.valid.NotValidWord;
import user.input.valid.Valid;
import user.input.valid.ValidNumber;

public class InputValidator {
  
  public static Valid checkInput(String userInput) {
    
    Valid validState = null;
    if (userInput.matches("\\d+")) {
      validState = new ValidNumber(userInput);
    } else if (userInput.startsWith("-")) {
      validState = new NotValidNegativeNumber(userInput);
    } else {
      validState = new NotValidWord(userInput);
    }
    return validState;
  }
  
}
