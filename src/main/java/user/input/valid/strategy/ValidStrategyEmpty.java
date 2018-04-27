package user.input.valid.strategy;

import user.output.message.Messages;

public class ValidStrategyEmpty extends ValidStrategy {
  
  public ValidStrategyEmpty(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action() {
    message.accept("Entered input is empty!");
    message.accept(Messages.PLEASE_ENTER_AGAIN);
  }
}
