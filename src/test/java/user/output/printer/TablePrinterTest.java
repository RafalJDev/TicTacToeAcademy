package user.output.printer;

import org.testng.annotations.Test;
import table.TableArray;
import user.io.wrapper.IOEntity;

import static org.testng.Assert.assertEquals;

public class TablePrinterTest {
  
  @Test
  public void printTable_typicalSituation_tableSizeNotChanged_alsoTesterCanSeeIfMethodIsProperlyPrintingTable() {
    int tableSize = 3;
    TableArray tableArray = TableArray.ofSquareTable(tableSize);
  
    TablePrinter.printTable(tableArray, IOEntity.of(() -> null, System.out::println));
  
    int actualGameTableSize = tableArray.getTableSizeOnX();
    
    assertEquals(actualGameTableSize, tableSize);
  }
  
  @Test
  public void printTable_tableSize_5_tableSizeNotChanged_alsoTesterCanSeeIfMethodIsProperlyPrintingTable() {
    int tableSize = 5;
    TableArray tableArray = TableArray.ofSquareTable(tableSize);
  
    TablePrinter.printTable(tableArray, IOEntity.of(() -> null, System.out::println));
  
    int actualGameTableSize = tableArray.getTableSizeOnX();
    
    assertEquals(actualGameTableSize, tableSize);
  }
  
  @Test(expectedExceptions = NegativeArraySizeException.class)
  public void createLineWithHorizontalBars_negativeRealTableSize_thenEmptyStringBuilder() {
    
    int negativeRealSize = -1;
    StringBuilder lineWithHorizontalBars = TablePrinter.createLineWithHorizontalBars(negativeRealSize);
    
    int lengthOfStringBuilder = lineWithHorizontalBars.length();
    
    int expectedSize = 0;
    assertEquals(lengthOfStringBuilder, expectedSize);
  }
  
  @Test
  public void createLineWithHorizontalBars_positiveCount_thenExpectTheSameLength() {
    
    int realCountOfSigns = 5;
    StringBuilder lineWithHorizontalBars = TablePrinter.createLineWithHorizontalBars(realCountOfSigns);
    
    int lengthOfStringBuilder = lineWithHorizontalBars.length();
    
    int expectedSize = 5;
    assertEquals(lengthOfStringBuilder, expectedSize);
  }
  
  @Test
  public void createLineWithHorizontalBars_positiveCount_() {
    
    int realCountOfSigns = 5;
    StringBuilder lineWithHorizontalBars = TablePrinter.createLineWithHorizontalBars(realCountOfSigns);
    
    String lineToString = lineWithHorizontalBars.toString();
    
    String expectedLine = "-----";
    assertEquals(lineToString, expectedLine);
  }
  
}