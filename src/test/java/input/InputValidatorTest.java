package input;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InputValidatorTest {
  
  InputValidator inputValidator;
  
  @BeforeMethod
  public void setUp() {
    inputValidator = new InputValidator();
  }
  
  @Test
  public void checkInput_letterAsAUserInput_thenNotValid() {
    String itCantBeLetter = "T";
    boolean result = InputValidator.checkInput(itCantBeLetter);
    
    boolean expectedNotValid = false;
    
    assertEquals(result, expectedNotValid);
  }
  
  @Test
  public void checkInput_numberAsUserInpput_lessThenZero_thenNotValid() {
    String itShouldntBeLessThan0 = "-1999";
    boolean result = InputValidator.checkInput(itShouldntBeLessThan0);
    
    boolean expectedNotValid = false;
    
    assertEquals(result, expectedNotValid);
  }
  
  @Test
  public void checkInput_numberAsUserInput_zero_thenValid() {
    String zero = "0";
    boolean result = InputValidator.checkInput(zero);
    
    boolean expectedValid = true;
    
    assertEquals(result, expectedValid);
  }
  
  @Test
  public void checkInput_numberAsUserInput_muchGreaterThanZero_thenValid() {
    String thousand = "1000";
    boolean result = InputValidator.checkInput(thousand);
    
    boolean expectedValid = true;
    assertEquals(result, expectedValid);
  }
}