package user.output.message;

import player.Player;

import java.util.function.Consumer;

public class MessagePrinter {
  
  public static void printMessage(Object message) {
    System.out.println(message.toString());
  }
  
  public static void printMessage(String sdfweg, String aefwfe, Consumer<String> consumer) {
    consumer.accept(sdfweg);
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
  
  public static void askForPosition() {
    System.out.println(Messages.PLEASE_GIVE_COORDINATES);
    System.out.println(Messages.ASK_FOR_POSITION);
  }
  
}
