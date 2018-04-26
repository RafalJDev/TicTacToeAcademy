package user.input.valid;

import user.output.message.MessagePrinter;
import user.output.message.Messages;

public class NotValidWord extends Valid {
  
  public NotValidWord(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action() {
    message.accept("Entered input " + userInput + " is not a number!");
    message.accept(Messages.PLEASE_ENTER_AGAIN);
  }
}
