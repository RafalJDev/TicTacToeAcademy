package user.input.asker;

import cell.Cell;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import player.Player;

import java.util.Random;
import java.util.function.Supplier;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class MoveAskerTest {
  
  private MoveAsker moveAsker;
  private Random random = new Random();
  private int passedUserInput;
  
  @BeforeMethod
  public void setUp() {
  }
  
  @Test
  public void askForCoordinates_emulateRandomPositiveInput_() {
    
    moveAsker = new MoveAsker(emulateRandomUserInput(100));
    Cell cell = moveAsker.askForCoordinates(Player.X);
    
    assertNotNull(cell);
  }
  
  @Test
  public void askForCoordinates_emulateSignlePositiveInput_coordinatesShouldBeNotNull() {
    
    int userInput = 1;
    
    moveAsker = new MoveAsker(emulateSingleUserInput(userInput));
    Cell cell = moveAsker.askForCoordinates(Player.X);
    
    int position = cell.getCellNumber();
    
    assertEquals(position, userInput);
  }
  
  private Supplier<String> emulateRandomUserInput(int bound) {
    passedUserInput = random.nextInt(bound);
    return () -> toString(passedUserInput);
  }
  
  private Supplier<String> emulateSingleUserInput(int input) {
    return () -> toString(input);
  }
  
  private Supplier<String> emulateUserInput_1(int i) {
    return () -> "1";
  }
  
  private String toString(int i) {
    return String.valueOf(i);
  }
}