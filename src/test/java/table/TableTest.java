package table;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TableTest {
  
  Table table;
  
  @BeforeMethod
  public void setUp() {
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Table can't be: " + 2)
  public void createNewTable_withIllegalArgument_thenException() {
  
    int toSmallTableSize = 2;
    table = Table.createNewTable(toSmallTableSize);
  }
  
  @Test
  public void createNewTable_correctSize() {
  
    int standardSize = 3;
    table = Table.createNewTable(standardSize);
  
    int gameTableSize = table.getGameTableSize();
  
    int expectedSize = 3;
    assertEquals(gameTableSize, expectedSize);
  }
}