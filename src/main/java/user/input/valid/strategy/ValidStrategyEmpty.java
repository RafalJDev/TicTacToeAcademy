package user.input.valid.strategy;

import user.io.wrapper.IOEntity;
import user.output.message.Messages;

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
