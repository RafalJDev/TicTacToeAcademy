package user.input;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import user.input.valid.NotValidNegativeNumber;
import user.input.valid.NotValidWord;
import user.input.valid.Valid;
import user.input.valid.ValidNumber;

import static org.testng.Assert.*;

public class InputValidatorTest {
  
  InputValidator inputValidator;
  
  @BeforeMethod
  public void setUp() {
    inputValidator = new InputValidator();
  }
  
  @Test
  public void checkInput_letterAsAUserInput_thenInstanceOf_NotValidWord() {
    String itCantBeLetter = "T";
    Valid result = InputValidator.checkInput(itCantBeLetter);
    
    assertTrue(result instanceof NotValidWord);
  }
  
  @Test
  public void checkInput_numberAsUserInpput_lessThenZero_thenInstanceOf_NotValidNegativeNumber() {
    String itShouldntBeLessThan0 = "-1999";
    Valid result = InputValidator.checkInput(itShouldntBeLessThan0);
    
    assertTrue(result instanceof NotValidNegativeNumber);
  }
  
  @Test
  public void checkInput_numberAsUserInput_zero_thenInstanceOf_ValidNumber() {
    String zero = "0";
    Valid result = InputValidator.checkInput(zero);
    
    boolean expectedValid = true;
    
    assertTrue(result instanceof ValidNumber);
  }
  
  @Test
  public void checkInput_numberAsUserInput_muchGreaterThanZero_thenInstanceOf_ValidNumber() {
    String thousand = "1000";
    Valid result = InputValidator.checkInput(thousand);
    
    assertTrue(result instanceof ValidNumber);
  }
}