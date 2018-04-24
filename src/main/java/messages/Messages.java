package messages;

public enum Messages {

  WELCOME ("HEY ! "),
  NEXT_PLAYER_IS("I don't know !"),
  FAREWALL("BYE !");
  
  private String message;
  
  Messages(String message) {
    this.message = message;
  }
  
  @Override
  public String toString() {
    return message;
  }
}
