package user.output.message;

public enum Messages {
  
  WELCOME("HEY ! This is tic tac toe service.game"),
  NEXT_PLAYER_IS("The next player is: "),
  PLEASE_GIVE_COORDINATES("Please give me cell to put your sign on table: "),
  ASK_FOR_POSITION("Position number (positive number): "),
  PLEASE_ENTER_AGAIN("Please enter number again : "),
  FAREWELL("BYE, till the next time !");
  
  private String message;
  
  Messages(String message) {
    this.message = message;
  }
  
  @Override
  public String toString() {
    return message;
  }
}
