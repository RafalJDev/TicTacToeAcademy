package user.input.valid.strategy;

import user.output.message.MessagePrinter;

import java.util.function.Consumer;

public abstract class ValidStrategy {
  
  protected String userInput;
  Consumer<Object> message = MessagePrinter::printMessage;
  
  public ValidStrategy(String userInput) {
    this.userInput = userInput;
  }
  
  public abstract void action();
}
