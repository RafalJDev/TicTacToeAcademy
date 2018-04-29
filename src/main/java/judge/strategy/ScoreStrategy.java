package judge.strategy;

import player.Player;
import table.Table;

public abstract class ScoreStrategy {
  
  protected Table table;
  protected Coordinates coordinates;
  protected Player currentPlayer;
  
  public abstract void action();
}
