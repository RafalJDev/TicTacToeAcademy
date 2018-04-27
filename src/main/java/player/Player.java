package player;

public enum Player {
  
  X("X") {
    @Override
    public Player getOppositePlayer() {
      return O;
    }
  },
  O("O") {
    @Override
    public Player getOppositePlayer() {
      return X;
    }
  };
  
  private String playerName;
  
  Player(String playerName) {
    this.playerName = playerName;
  }
  
  public String getPlayerName() {
    return playerName;
  }
  
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
  
  public abstract Player getOppositePlayer();
  
  public char toChar() {
    return name().charAt(0);
  }
}
