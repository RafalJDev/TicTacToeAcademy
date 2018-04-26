package user.input.valid;

import user.output.message.MessagePrinter;

public class NotValidNegativeNumber extends Valid {
  
  public NotValidNegativeNumber(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action() {
    message.accept("Number " + userInput + " must be greater than 0! Please enter position again: ");
  }
}
