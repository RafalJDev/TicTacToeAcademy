package cell;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoordinatesTest {
  
  Coordinates coordinates;
  
  @Test()
  public void createCoordinates_passNegativeXIndex_thenException() {
  
    int negativeCoordinate_X = -1;
    coordinates = Coordinates.of(negativeCoordinate_X, 0);

    assertNull(coordinates);
  }
  
  @Test()
  public void createCoordinates_passNegativeYIndex_thenException() {
    
    int negativeCoordinate_Y = -1;
    coordinates = Coordinates.of(0, negativeCoordinate_Y);

    assertNull(coordinates);
  }
  
  @Test
  public void createCoordinates_positivePosition_thenCorrect() {
  
    coordinates = Coordinates.of(3, 3);
  
    int actualXPosition = coordinates.getXPosition();
    int actualYPosition = coordinates.getYPosition();
  
    int expectedPosition = 3;
    
    assertEquals(actualXPosition, expectedPosition);
    assertEquals(actualYPosition, expectedPosition);
  }
}