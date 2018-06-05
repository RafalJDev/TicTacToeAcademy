package user.io.input.asker;

import player.Player;
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
  
    printMessage("Please specify height of the table?");
    int ySize = readLineToInt();
    
    return new TableSize(xSize, ySize);
  }
  
  public int askForHowMuchSignsToWin(TableSize tableSize) {
    int howMuchSignsToWin;
    
    printMessage("How many signs would be needed to win the game ?");
    howMuchSignsToWin = readLineToInt();
    
    String messageToStupidUser;
    while (tableSize.checkIfNumberIsMoreThanSize(howMuchSignsToWin)) {
      messageToStupidUser = "STUPID! "
          + tableSize.sayToMeHowBigYouAre()
          + " And you want win the game with: "
          + howMuchSignsToWin + " signs ? "
          + "Enter good number or I will come to your house and install windows on your machine:";
      printMessage(messageToStupidUser);
      
      howMuchSignsToWin = readLineToInt();
    }
    
    return howMuchSignsToWin;
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
  
  public Player askForPlayersName() {
    Player player = Player.X;
    
    askForPlayerName(player);
    
    player = player.getOppositePlayer();
    askForPlayerName(player);
    
    return player.getOppositePlayer();
  }
  
  public void askForColor() {
  
  }
  
  private void askForPlayerName(Player player) {
    printMessage("How would you like to name Player \"" + player.getPlayerName() + "\" ?");
    String name = readLineToString();
    player.setPlayerName(name);
  }
  
  private void printMessage(String message) {
    localIO.acceptOutput(message);
  }
}