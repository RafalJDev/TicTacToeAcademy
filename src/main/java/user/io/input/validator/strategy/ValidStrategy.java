package user.io.input.validator.strategy;

import user.io.wrapper.IOEntity;

public abstract class ValidStrategy {
  
  String userInput;
  
  ValidStrategy(String userInput) {
    this.userInput = userInput;
  }
  
  public abstract void action(IOEntity ioEntity);
}
