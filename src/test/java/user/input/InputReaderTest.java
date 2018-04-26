package user.input;

import org.testng.annotations.Test;
import user.input.valid.NotValidWord;
import user.input.valid.ValidNumber;

import java.util.Random;
import java.util.function.Supplier;

import static org.testng.Assert.*;

public class InputReaderTest {
  
  Random random = new Random();
  
  @Test
  public void readLine_supplierAsRandomGenerator_positiveInput_thenReturnedLineGreaterThanZero() {
    
    Supplier<String> supplier = () -> String.valueOf(random.nextInt(100));
    
    int returnedLine = InputReader.readLine(supplier);
    
    assertTrue(returnedLine >= 0);
  }
  
  //TODO TestNG timeout doesn't work, so I made some magic
  volatile int returnedLine;
  
  @Test()
  public void readLine_supplierAsRandomGenerator_negativeInput_thenReturnedBigNegative() throws InterruptedException {
    
    int bigNegativeValueThatWontBeGeneratedByGenerator = -2000;
    returnedLine = bigNegativeValueThatWontBeGeneratedByGenerator;
    
    Thread input = new Thread(() -> {
      Supplier<String> supplier = () -> String.valueOf(random.nextInt(100) - 101);
      
      returnedLine = InputReader.readLine(supplier);
      
      fail("STUPID! You can't return any value! STUPID!");
    });
    input.start();
    
    input.join(300);
    
    int expected = bigNegativeValueThatWontBeGeneratedByGenerator;
    assertEquals(returnedLine, expected);
  }
  
  @Test
  public void isNotValid_passedValidClass_thenFalse() {
    boolean isNotValid = InputReader.isNotValid(new ValidNumber("1"));
    
    assertFalse(isNotValid);
  }
  
  @Test
  public void isNotValid_passedNotValidClass_thenTrue() {
    boolean isNotValid = InputReader.isNotValid(new NotValidWord("1"));
    
    assertTrue(isNotValid);
  }
}