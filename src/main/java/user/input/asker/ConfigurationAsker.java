package user.input.asker;

import table.entity.wrapper.TableSize;
import user.io.wrapper.IOEntity;

public class ConfigurationAsker extends Asker {
  
  public ConfigurationAsker(IOEntity localIO) {
    super(localIO);
  }
  
  public TableSize askForTableSizes() {
    printMessage("Do you want to play on square table ? [Y/N]");
    boolean yesOrNo = yesOrNo();
    
    if (yesOrNo) {
      printMessage("How big table you wish to play on ? ");
      final int tableSizeFromUser = readLineToInt();
      return new TableSize(tableSizeFromUser, tableSizeFromUser);
    }
    
    printMessage("Please specify width of the table?");
    int xSize = readLineToInt();
    
    printMessage("Please specify width of the table?");
    int ySize = readLineToInt();
    
    return new TableSize(xSize, ySize);
  }
  
  public int askForHowMuchSignsToWin() {
    printMessage("Hey ! How many signs would be needed to win the game ?");
    return readLineToInt();
  }
  
  private void printMessage(String message) {
    localIO.acceptOutput(message);
  }
  
  private boolean yesOrNo() {
    while (true) {
      String input = localIO.getInput();
      if (input.equals("Y")) {
        return true;
      } else if (input.equals("N")) {
        return false;
      }
      printMessage("Please enter [Y]es or [N]o");
    }
  }
  
  public void askForColor() {
  
  }
  
  public String askForUserName() {
    return "Some name";
  }
  
}