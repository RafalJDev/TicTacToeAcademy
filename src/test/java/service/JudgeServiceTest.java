package service;

import cell.Cell;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import player.Player;
import score.LineChecker;
import table.Table;
import user.io.output.printer.TablePrinter;
import user.io.wrapper.IOEntity;

import static org.testng.Assert.assertEquals;

public class JudgeServiceTest {
  
  private Table table;
  private Cell lastCell;
  private Player currentPlayer;
  
  @Mock
  private IOEntity ioEntity;
  
  @DataProvider(name = "allWinningCombinations_allYerOrNoCombinations")
  public static Object[][] allWinningCombinations_allYerOrNoCombinations() {
    return new Object[][]{
        {"Y", true, 1, 2, 3},
        {"N", false, 1, 2, 3},
        
        {"Y", true, 1, 4, 7},
        {"N", false, 1, 4, 7},
        
        {"Y", true, 1, 5, 9},
        {"N", false, 1, 5, 9},
        
        {"Y", true, 7, 5, 3},
        {"N", false, 7, 5, 3}
    };
  }
  
  @BeforeMethod
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    table = Table.ofSquareTable(3);
  }
  
  @Test(dataProvider = "allWinningCombinations_allYerOrNoCombinations")
  public void testCheckGameState_allWinningCombinations(String userInput, boolean expectedResult, int... positionsToMakeMove) {
    
    currentPlayer = Player.X;
    
    makeMoves(currentPlayer.toString(), positionsToMakeMove);
  
    boolean isThisEndOfTheGame = JudgeService.checkGameState(table, lastCell, getIoEntity(userInput));
  
    TablePrinter.printTable(table, IOEntity.of(() -> null, (s) -> {
    }));
    assertEquals(isThisEndOfTheGame, expectedResult);
  }
  
  private IOEntity getIoEntity(String yerOrNo) {
    return IOEntity.of(() -> yerOrNo, s -> System.out.print(""));
  }
  
  private void makeMoves(String playerSign, int... movesPositions) {
    //TODO WET this method is copied from LineCheckerTest, double Table.ofSquareTable to prevent Intellij to highlight it
  
    Cell cell = Cell.of(1, playerSign);
    currentPlayer = Player.valueOf(playerSign);
  
    LineChecker.prepareChecker(table, cell);
    
    for (int movesPosition : movesPositions) {
      MoveService.makeMove(table, currentPlayer, IOEntity.of(() -> String.valueOf(movesPosition), s -> {
      }));
      lastCell = Cell.of(movesPosition, playerSign);
    }
  }
}