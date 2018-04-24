package messages;

import player.Player;

public class MessagePrinter {
  
  public static void printMessage(String message) {
    System.out.println(message);
  }
  
  public static void printMessage(Messages message) {
    System.out.println(message);
  }
  
  public static void printMessage(Messages message, String additionalMessage) {
    System.out.println(message + " " + additionalMessage);
  }
  
  public static void printWhoIsNextPlayer(String whoIsnextPlayer) {
    System.out.println(Messages.NEXT_PLAYER_IS + " " + whoIsnextPlayer);
  }
  
}
