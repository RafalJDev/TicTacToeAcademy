package user.input.asker;

import cell.Cell;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import player.Player;
import user.io.entity.IOEntity;

import java.util.Random;

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
  
  private IOEntity emulateRandomUserInput(int bound) {
    passedUserInput = random.nextInt(bound);
    return IOEntity.of(() -> toString(passedUserInput), null);
  }
  
  private IOEntity emulateSingleUserInput(int input) {
    return IOEntity.of(() -> toString(input), null);
  }
  
  private IOEntity emulateUserInput_1(int i) {
    return IOEntity.of(() -> "1", null);
  }
  
  private String toString(int i) {
    return String.valueOf(i);
  }
}