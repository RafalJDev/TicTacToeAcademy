package user.output.message;

import player.Player;

public class MessagePrinter {
  
  public static void printMessage(Object message) {
    System.out.println(message.toString());
  }
  
  public static void printMessage(String message) {
    System.out.println(message);
  }
  
  public static void printMessage(Messages message) {
    System.out.println(message);
  }
  
  public static void printMessage(Messages message, String additionalMessage) {
    System.out.println(message + " " + additionalMessage);
  }
  
  
  public static void printWhoIsNextPlayer(Player whoIsnextPlayer) {
    System.out.println(Messages.NEXT_PLAYER_IS + " " + whoIsnextPlayer);
  }
  
  public static void askForCoordinatesOnX() {
    System.out.println(Messages.PLEASE_GIVE_COORDINATES);
    System.out.println(Messages.X_COORDINATE);
  }
  
  public static void askForCoordinatesOnY() {
    System.out.println(Messages.Y_COORDINATE);
  }
  
}
