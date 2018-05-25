package user.input.valid.strategy;

import user.io.wrapper.IOEntity;

public class ValidStrategyNegativeNumber extends ValidStrategy {
  
  public ValidStrategyNegativeNumber(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action(IOEntity ioEntity) {
    ioEntity.acceptOutput("Number " + userInput + " must be greater than 0! Please enter number again: ");
  }
}
