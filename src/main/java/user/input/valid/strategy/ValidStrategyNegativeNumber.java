package user.input.valid.strategy;

public class ValidStrategyNegativeNumber extends ValidStrategy {
  
  public ValidStrategyNegativeNumber(String userInput) {
    super(userInput);
  }
  
  @Override
  public void action() {
    message.accept("Number " + userInput + " must be greater than 0! Please enter position again: ");
  }
}
