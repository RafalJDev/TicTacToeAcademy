package user.input;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user.input.valid.strategy.ValidStrategy;
import user.input.valid.strategy.ValidStrategyNegativeNumber;
import user.input.valid.strategy.ValidStrategyNumber;
import user.input.valid.strategy.ValidStrategyWord;

import static org.testng.Assert.assertTrue;

public class InputValidatorTest {
  
  InputValidator inputValidator;
  
  @BeforeMethod
  public void setUp() {
    inputValidator = new InputValidator();
  }
  
  @Test
  public void checkInput_letterAsAUserInput_thenInstanceOf_NotValidWord() {
    String itCantBeLetter = "T";
    ValidStrategy result = InputValidator.checkInput(itCantBeLetter);
    
    assertTrue(result instanceof ValidStrategyWord);
  }
  
  @Test
  public void checkInput_numberAsUserInpput_lessThenZero_thenInstanceOf_NotValidNegativeNumber() {
    String itShouldntBeLessThan0 = "-1999";
    ValidStrategy result = InputValidator.checkInput(itShouldntBeLessThan0);
    
    assertTrue(result instanceof ValidStrategyNegativeNumber);
  }
  
  @Test
  public void checkInput_numberAsUserInput_zero_thenInstanceOf_ValidNumber() {
    String zero = "0";
    ValidStrategy result = InputValidator.checkInput(zero);
    
    boolean expectedValid = true;
    
    assertTrue(result instanceof ValidStrategyNumber);
  }
  
  @Test
  public void checkInput_numberAsUserInput_muchGreaterThanZero_thenInstanceOf_ValidNumber() {
    String thousand = "1000";
    ValidStrategy result = InputValidator.checkInput(thousand);
    
    assertTrue(result instanceof ValidStrategyNumber);
  }
}