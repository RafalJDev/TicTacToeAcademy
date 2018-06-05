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
  
  private String playerSign;
  private String playerName;
  
  Player(String playerSign) {
    this.playerSign = playerSign;
    playerName = playerSign;
  }
  
  public abstract Player getOppositePlayer();
  
  public String getPlayerName() {
    return playerName;
  }
  
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
  
  @Override
  public String toString() {
    return playerSign;
  }
}
