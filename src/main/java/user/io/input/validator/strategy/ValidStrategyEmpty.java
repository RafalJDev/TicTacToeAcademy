package user.io.input.validator.strategy;

import user.io.output.message.Messages;
import user.io.wrapper.IOEntity;

public class ValidStrategyEmpty extends ValidStrategy {
  
  public ValidStrategyEmpty(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action(IOEntity ioEntity) {
    ioEntity.acceptOutput("Entered input is empty!");
    ioEntity.acceptOutput(Messages.PLEASE_ENTER_AGAIN.toString());
  }
}
