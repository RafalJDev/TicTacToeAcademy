package coordinates;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoordinatesTest {
  
  Coordinates coordinates;
  
  @BeforeMethod
  public void setUp() {
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Passed X position has a negative value")
  public void createCoordinates_passNegativeXIndex_thenException() {
  
    int negativeCoordinate_X = -1;
    coordinates = Coordinates.createCoordinates(negativeCoordinate_X, 0);
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Passed Y position has a negative value")
  public void createCoordinates_passNegativeYIndex_thenException() {
    
    int negativeCoordinate_Y = -1;
    coordinates = Coordinates.createCoordinates(0, negativeCoordinate_Y);
  }
  
  @Test
  public void createCoordinates_positivePosition_thenCorrect() {
  
    coordinates = Coordinates.createCoordinates(3, 3);
  
    int actualXPosition = coordinates.getXPosition();
    int actualYPosition = coordinates.getYPosition();
  
    int expectedPosition = 3;
    
    assertEquals(actualXPosition, expectedPosition);
    assertEquals(actualYPosition, expectedPosition);
  }
}