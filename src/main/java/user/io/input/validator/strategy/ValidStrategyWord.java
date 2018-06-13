package user.io.input.validator.strategy;

import user.io.output.message.Messages;
import user.io.wrapper.IOEntity;

public class ValidStrategyWord extends ValidStrategy {
  
  public ValidStrategyWord(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action(IOEntity ioEntity) {
    ioEntity.acceptOutput("Entered input " + userInput + " is not a number!");
    ioEntity.acceptOutput(Messages.PLEASE_ENTER_AGAIN.toString());
  }
}
