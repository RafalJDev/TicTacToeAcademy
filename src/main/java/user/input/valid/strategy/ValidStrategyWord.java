package user.input.valid.strategy;

import user.output.message.Messages;

public class ValidStrategyWord extends ValidStrategy {
  
  public ValidStrategyWord(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action() {
    message.accept("Entered input " + userInput + " is not a number!");
    message.accept(Messages.PLEASE_ENTER_AGAIN);
  }
}
