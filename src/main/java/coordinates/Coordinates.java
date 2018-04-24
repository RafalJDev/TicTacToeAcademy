package coordinates;

public class Coordinates {
  
  private int x;
  private int y;
  
  private Coordinates(int xPosition, int yPosition) {
    x = xPosition;
    y = yPosition;
  }
  
  public static Coordinates createCoordinates(int xPosition, int yPosition) throws IllegalArgumentException{
    if (xPosition < 0 ) {
      throw new IllegalArgumentException("Passed X position has a negative value");
    } else if (yPosition < 0) {
      throw new IllegalArgumentException("Passed Y position has a negative value");
    }
    return new Coordinates(xPosition, yPosition);
  }
  
  public int getXPosition() {
    return x;
  }
  
  public int getYPosition() {
    return y;
  }
}
