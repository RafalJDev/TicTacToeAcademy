package user.input.valid;

import user.output.message.MessagePrinter;

import java.util.function.Consumer;

public abstract class Valid {
  
  String userInput;
  Consumer<Object> message = MessagePrinter::printMessage;
  
  public Valid(String userInput) {
    this.userInput = userInput;
  }
  
  public abstract void action();
}
