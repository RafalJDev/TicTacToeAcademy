package user.io.input;

import org.testng.annotations.Test;
import user.io.input.validator.strategy.ValidStrategyNumber;
import user.io.input.validator.strategy.ValidStrategyWord;
import user.io.wrapper.IOEntity;

import java.util.Random;
import java.util.function.Supplier;

import static org.testng.Assert.*;

public class InputReaderTest {
  
  private Random random = new Random();
  
  @Test
  public void readLine_supplierAsRandomGenerator_positiveInput_thenReturnedLineGreaterThanZero() {
    
    Supplier<String> supplier = () -> String.valueOf(random.nextInt(100));
  
    String returnedLine = InputReader.readLine(IOEntity.of(supplier, null));
    
    assertTrue(Integer.parseInt(returnedLine) >= 0);
  }
  
  //TODO TestNG timeout doesn't work, so I do some magic
  private volatile String returnedLine;
  
  @Test()
  public void readLine_supplierAsRandomGenerator_negativeInput_thenReturnedBigNegative() throws InterruptedException {
    
    int bigNegativeValueThatWontBeGeneratedByGenerator = -2000;
    returnedLine = String.valueOf(bigNegativeValueThatWontBeGeneratedByGenerator);
    
    Thread input = new Thread(() -> {
      Supplier<String> supplier = () -> String.valueOf(random.nextInt(100) - 101);
  
      returnedLine = InputReader.readLine(IOEntity.of(supplier, s -> {
      }));
      
      fail("STUPID! You can't return any value! STUPID!");
    });
    input.start();
    
    input.join(300);
    
    int expected = bigNegativeValueThatWontBeGeneratedByGenerator;
    String expectedString = String.valueOf(expected);
    assertEquals(returnedLine, expectedString);
  }
  
  @Test
  public void isNotValid_passedValidClass_thenFalse() {
    boolean isNotValid = InputReader.isNotValid(new ValidStrategyNumber("1"));
    
    assertFalse(isNotValid);
  }
  
  @Test
  public void isNotValid_passedNotValidClass_thenTrue() {
    boolean isNotValid = InputReader.isNotValid(new ValidStrategyWord("1"));
    
    assertTrue(isNotValid);
  }
}