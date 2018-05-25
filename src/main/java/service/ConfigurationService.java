package service;

import table.TableArray;
import table.wrapper.TableSize;
import user.input.InputReader;
import user.io.wrapper.IOEntity;

class ConfigurationService {
  
  private IOEntity localIO;
  
  public TableArray configureGame(IOEntity ioEntity) {
    localIO = ioEntity;
    
    TableSize tableSize = askForTableSizes();
    
    int howMuchSignsToWin = askForHowMuchSignsToWin();
    
    return TableArray.of(tableSize, howMuchSignsToWin);
  }
  
  //TODO to akser
  private TableSize askForTableSizes() {
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
  
  private int askForHowMuchSignsToWin() {
    printMessage("Hey ! How many signs would be needed to win the game ?");
    return readLineToInt();
  }
  
  private void printMessage(String message) {
    localIO.acceptOutput(message);
  }
  
  private int readLineToInt() {
    String s = InputReader.readLine(localIO);
    return Integer.parseInt(s);
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
  
}
