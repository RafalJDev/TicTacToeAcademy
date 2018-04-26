package user.output.printer;

import org.testng.annotations.Test;
import table.Table;

import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

public class TablePrinterTest {
  
  @Test
  public void printTable_typicalSituation_tableSizeNotChanged_alsoTesterCanSeeIfMethodIsProperlyPrintingTable() {
    int tableSize = 3;
    char signToFillTableWith = ' ';
    Table table = Table.of(tableSize, signToFillTableWith);
    Consumer<StringBuilder> stringConsumer = System.out::println;
  
    TablePrinter.printTable(table, stringConsumer);
    
    int actualGameTableSize = table.getGameTableSize();
    int tableSizeNotChanged = 3;
    
    assertEquals(actualGameTableSize, tableSizeNotChanged);
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