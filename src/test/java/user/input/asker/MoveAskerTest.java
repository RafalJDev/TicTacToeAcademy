package user.input.asker;

import coordinates.Coordinates;
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
    Coordinates coordinates = moveAsker.askForCoordinates(Player.X);
    
    assertNotNull(coordinates);
  }
  
  @Test
  public void askForCoordinates_emulateSignlePositiveInput_coordinatesShouldBeNotNull() {
    
    int userInput = 1;
    
    moveAsker = new MoveAsker(emulateSingleUserInput(userInput));
    Coordinates coordinates = moveAsker.askForCoordinates(Player.X);
    
    int xPosition = coordinates.getXPosition();
    int yPosition = coordinates.getYPosition();
    
    assertEquals(xPosition, userInput);
    assertEquals(yPosition, userInput);
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